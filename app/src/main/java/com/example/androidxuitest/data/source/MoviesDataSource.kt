package com.example.androidxuitest.data.source

import com.example.androidxuitest.data.Movie

interface MoviesDataSource {
    fun getMovie(movieId: Int): Movie?

    fun getMovies(): List<Movie>
}