package com.viola2013.popularmoviesapp

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class SmokeTest {

    @Test
    fun movie_dataModel_isCorrect() {
        val movie = Movie(
            originalTitle = "Interstellar",
            posterPath = "/path.jpg",
            overview = "A team of explorers travel through a wormhole in space...",
            voteAverage = 8.6,
            releaseDate = "2014-11-07"
        )

        assertEquals("Interstellar", movie.originalTitle)
        assertEquals("https://image.tmdb.org/t/p/w185/path.jpg", movie.getFullPosterPath())
        assertEquals("8.6/10", movie.getDetailedVoteAverage())
        assertEquals("yyyy-MM-dd", movie.getDateFormat())
    }

    @Test
    fun movie_defaultValues_areCorrect() {
        val movie = Movie()
        assertNotNull(movie)
        assertEquals("0.0/10", movie.getDetailedVoteAverage())
    }
}
