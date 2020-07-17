package com.example.androidxuitest.data.source

import com.example.androidxuitest.data.DummyMovies.INFINITY_WAR
import com.example.androidxuitest.data.DummyMovies.THE_RUNDOWN
import com.example.androidxuitest.data.FakeMovieData
import com.example.androidxuitest.data.Movie

class MoviesRemoteDataSource : MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(FakeMovieData.movies.size)

    init {
        for (movie in FakeMovieData.movies){
            addMovie(movie)
        }
    }

    override fun getMovies(): List<Movie> {
        return ArrayList(MOVIES_REMOTE_DATA.values)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
    }

    private fun addMovie(
        movie: Movie
    ){
        MOVIES_REMOTE_DATA.put(movie.id, movie)
    }

}