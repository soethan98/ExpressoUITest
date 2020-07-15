package com.example.androidxuitest.data.source

import com.example.androidxuitest.data.DummyMovies.INFINITY_WAR
import com.example.androidxuitest.data.DummyMovies.THE_RUNDOWN
import com.example.androidxuitest.data.Movie

object MoviesRemoteDataSource : MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(2)

    init {
        addMovie(INFINITY_WAR)
        addMovie(THE_RUNDOWN)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
    }

    private fun addMovie(movie: Movie) {
        MOVIES_REMOTE_DATA[movie.id] = movie
    }
}