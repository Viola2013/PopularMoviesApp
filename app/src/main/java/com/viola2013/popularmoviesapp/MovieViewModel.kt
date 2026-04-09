package com.viola2013.popularmoviesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

sealed class MovieUiState {
    object Idle : MovieUiState()
    object Loading : MovieUiState()
    data class Success(val movies: List<Movie>) : MovieUiState()
    data class Error(val message: String) : MovieUiState()
}

class MovieViewModel(
    private val application: Application,
    private val repository: MovieRepository,
    private val apiKey: String,
    private val connectivityObserver: ConnectivityObserver
) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow<MovieUiState>(MovieUiState.Idle)
    val uiState: StateFlow<MovieUiState> = _uiState.asStateFlow()

    private val _sortMethod = MutableStateFlow("popularity.desc")
    val sortMethod: StateFlow<String> = _sortMethod.asStateFlow()

    private val _networkStatus = MutableStateFlow(ConnectivityObserver.Status.Available)
    val networkStatus: StateFlow<ConnectivityObserver.Status> = _networkStatus.asStateFlow()

    init {
        connectivityObserver.observe().onEach { status ->
            _networkStatus.value = status
            if (status == ConnectivityObserver.Status.Available && _uiState.value is MovieUiState.Error) {
                fetchMovies()
            }
        }.launchIn(viewModelScope)
    }

    fun updateSortMethod(newSort: String) {
        _sortMethod.value = newSort
        fetchMovies()
    }

    fun fetchMovies() {
        Log.d("MovieViewModel", "fetchMovies called")
        viewModelScope.launch {
            if (apiKey.isBlank()) {
                Log.e("MovieViewModel", "API Key is blank")
                _uiState.value = MovieUiState.Error(application.getString(R.string.error_missing_api_key))
                return@launch
            }

            if (_networkStatus.value != ConnectivityObserver.Status.Available) {
                Log.w("MovieViewModel", "Network not available: ${_networkStatus.value}")
                _uiState.value = MovieUiState.Error(application.getString(R.string.error_no_internet))
                return@launch
            }

            _uiState.value = MovieUiState.Loading
            try {
                Log.d("MovieViewModel", "Calling repository.fetchMovies")
                val result = repository.fetchMovies(_sortMethod.value)
                if (result != null) {
                    Log.d("MovieViewModel", "Success: ${result.size} movies fetched")
                    _uiState.value = MovieUiState.Success(result)
                } else {
                    Log.e("MovieViewModel", "Repository returned null")
                    _uiState.value = MovieUiState.Error(application.getString(R.string.error_fetch_failed))
                }
            } catch (e: Exception) {
                Log.e("MovieViewModel", "Exception during fetch", e)
                _uiState.value = MovieUiState.Error(e.localizedMessage ?: application.getString(R.string.error_fetch_failed))
            }
        }
    }
}

class MovieViewModelFactory(private val application: Application, private val apiKey: String, private val connectivityObserver: ConnectivityObserver) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(application, MovieRepository(apiKey), apiKey, connectivityObserver) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
