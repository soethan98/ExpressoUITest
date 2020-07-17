package com.example.androidxuitest.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.request.RequestOptions
import com.example.androidxuitest.data.source.MoviesDataSource
import com.example.androidxuitest.ui.movie.DirectorsFragment
import com.example.androidxuitest.ui.movie.MovieDetailFragment
import com.example.androidxuitest.ui.movie.MovieListFragment
import com.example.androidxuitest.ui.movie.StarActorsFragment

class MovieFragmentFactory constructor(
    private val requestOptions: RequestOptions? = null,
    private val moviesDataSource: MoviesDataSource? = null
) : FragmentFactory() {

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {

            MovieListFragment::class.java.name -> {
                if (moviesDataSource != null) {
                    MovieListFragment(moviesDataSource)
                } else {
                    super.instantiate(classLoader, className)
                }
            }

            MovieDetailFragment::class.java.name -> {
                if (requestOptions != null
                    && moviesDataSource != null
                ) {
                    MovieDetailFragment(
                        requestOptions,
                        moviesDataSource
                    )
                } else {
                    super.instantiate(classLoader, className)
                }
            }
            DirectorsFragment::class.java.name -> DirectorsFragment()
            StarActorsFragment::class.java.name -> StarActorsFragment()
            else -> super.instantiate(classLoader, className)

        }
    }

}