package com.viola2013.popularmoviesapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var originalTitle: String? = null,
    var posterPath: String? = null,
    var overview: String? = null,
    var voteAverage: Double? = 0.0,
    var releaseDate: String? = null
) : Parcelable {

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd"
        private const val TMDB_POSTER_BASE_URL = "https://image.tmdb.org/t/p/w185"
    }

    fun getFullPosterPath(): String? {
        return posterPath?.let { "$TMDB_POSTER_BASE_URL$it" }
    }

    fun getDetailedVoteAverage(): String {
        return "${voteAverage ?: 0.0}/10"
    }

    fun getDateFormat(): String = DATE_FORMAT
}
