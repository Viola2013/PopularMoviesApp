package com.viola2013.popularmoviesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies.asStateFlow()

    private val _sortMethod = MutableStateFlow("popularity.desc")
    val sortMethod: StateFlow<String> = _sortMethod.asStateFlow()

    fun updateSortMethod(newSort: String) {
        _sortMethod.value = newSort
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            val result = repository.fetchMovies(_sortMethod.value)
            _movies.value = result ?: emptyList()
        }
    }
}

class MovieViewModelFactory(private val apiKey: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(MovieRepository(apiKey)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
