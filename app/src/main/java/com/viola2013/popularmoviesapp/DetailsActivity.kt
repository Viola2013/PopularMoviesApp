package com.viola2013.popularmoviesapp

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.viola2013.popularmoviesapp.ui.screens.DetailsScreen
import com.viola2013.popularmoviesapp.ui.theme.PopularMoviesAppTheme

class DetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(getString(R.string.parcel_movie), Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(getString(R.string.parcel_movie))
        }

        if (movie == null) {
            finish()
            return
        }

        setContent {
            PopularMoviesAppTheme {
                DetailsScreen(
                    movie = movie,
                    onBackClick = { finish() },
                    onFavoriteClick = {
                        // Simulate favorite toggle
                        Toast.makeText(this, getString(R.string.favorite_added), Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
