package com.viola2013.popularmoviesapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import androidx.core.net.toUri

class MovieRepository(private val apiKey: String) {

    suspend fun fetchMovies(sortMethod: String): List<Movie>? = withContext(Dispatchers.IO) {
        val tmdbBaseUrl = "https://api.themoviedb.org/3/discover/movie"
        val sortByParam = "sort_by"
        val apiKeyParam = "api_key"

        val builtUri = tmdbBaseUrl.toUri().buildUpon()
            .appendQueryParameter(sortByParam, sortMethod)
            .appendQueryParameter(apiKeyParam, apiKey)
            .build()

        val url = URL(builtUri.toString())
        var urlConnection: HttpURLConnection? = null
        try {
            urlConnection = url.openConnection() as HttpURLConnection
            val jsonResponse = urlConnection.inputStream.bufferedReader().use { it.readText() }
            return@withContext parseMoviesJson(jsonResponse)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        } finally {
            urlConnection?.disconnect()
        }
    }

    private fun parseMoviesJson(jsonString: String): List<Movie> {
        val movies = mutableListOf<Movie>()
        val moviesJson = JSONObject(jsonString)
        val resultsArray = moviesJson.getJSONArray("results")

        for (i in 0 until resultsArray.length()) {
            val movieInfo = resultsArray.getJSONObject(i)
            movies.add(
                Movie(
                    originalTitle = movieInfo.optString("original_title"),
                    posterPath = movieInfo.optString("poster_path"),
                    overview = movieInfo.optString("overview"),
                    voteAverage = movieInfo.optDouble("vote_average"),
                    releaseDate = movieInfo.optString("release_date")
                )
            )
        }
        return movies
    }
}
