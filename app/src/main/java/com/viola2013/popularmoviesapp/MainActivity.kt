package com.viola2013.popularmoviesapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.viola2013.popularmoviesapp.ui.screens.MainScreen
import com.viola2013.popularmoviesapp.ui.theme.PopularMoviesAppTheme
import androidx.appcompat.app.AlertDialog

class MainActivity : ComponentActivity() {

    private lateinit var connectivityObserver: ConnectivityObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        
        setContent {
            val context = LocalContext.current
            val viewModel: MovieViewModel = viewModel(
                factory = MovieViewModelFactory(application, BuildConfig.TMDB_API_KEY, connectivityObserver)
            )
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val currentSort by viewModel.sortMethod.collectAsStateWithLifecycle()
            val networkStatus by viewModel.networkStatus.collectAsStateWithLifecycle()

            PopularMoviesAppTheme {
                MainScreen(
                    uiState = uiState,
                    networkStatus = networkStatus,
                    onMovieClick = { movie ->
                        val intent = Intent(context, DetailsActivity::class.java).apply {
                            putExtra(getString(R.string.parcel_movie), movie)
                        }
                        context.startActivity(intent)
                    },
                    onSortChange = { newSort ->
                        viewModel.updateSortMethod(newSort)
                    },
                    currentSort = currentSort,
                    onAboutClick = {
                        showAboutDialog()
                    },
                    onRetry = {
                        viewModel.fetchMovies()
                    }
                )
            }
        }
    }

    private fun showAboutDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.about_button)
            .setMessage(R.string.app_usage)
            .setPositiveButton(android.R.string.ok, null)
            .show()
    }
}
