package com.example.androidxuitest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.request.RequestOptions
import com.example.androidxuitest.R
import com.example.androidxuitest.data.source.MoviesDataSource
import com.example.androidxuitest.data.source.MoviesRemoteDataSource
import com.example.androidxuitest.factory.MovieFragmentFactory
import com.example.androidxuitest.ui.movie.MovieDetailFragment

class MainActivity : AppCompatActivity() {

    // dependencies (typically would be injected with dagger)
    lateinit var requestOptions: RequestOptions
    lateinit var moviesDataSource: MoviesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(
            requestOptions,
            moviesDataSource
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun initDependencies() {
        // glide
        requestOptions = RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)

        // Data Source
        moviesDataSource = MoviesRemoteDataSource()
    }

    private fun init() {
        if (supportFragmentManager.fragments.size == 0) {
            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction().replace(
                R.id.container, MovieDetailFragment::class.java
                , bundle
            ).commit()
        }
    }
}