package com.example.androidxuitest.ui.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidxuitest.R
import com.example.androidxuitest.data.Movie
import com.example.androidxuitest.data.source.MoviesDataSource
import com.example.androidxuitest.data.source.MoviesRemoteDataSource
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment constructor(
    val requestOptions: RequestOptions,
    private val movieDataSource: MoviesDataSource
) : Fragment(R.layout.fragment_movie_detail) {
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getInt("movie_id").let { movieId ->
                movieDataSource.getMovie(movieId)?.let {
                    movie = it


                }

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMovieDetails()

        movie_directors.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_directors", movie.directors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DirectorsFragment::class.java, bundle)
                ?.addToBackStack("DirectorsFragment")
                ?.commit()
        }

        movie_star_actors.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_actors", movie.star_actors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, StarActorsFragment::class.java, bundle)
                ?.addToBackStack("StarActorsFragment")
                ?.commit()
        }
    }

    private fun setMovieDetails() {
        Glide.with(this)
            .applyDefaultRequestOptions(requestOptions)
            .load(movie.image)
            .into(movie_image)
        movie_title.text = movie.title
        movie_description.text = movie.description

    }
}