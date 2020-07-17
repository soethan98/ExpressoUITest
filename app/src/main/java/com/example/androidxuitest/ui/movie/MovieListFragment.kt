package com.example.androidxuitest.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidxuitest.R
import com.example.androidxuitest.data.Movie
import com.example.androidxuitest.data.source.MoviesDataSource
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment(val moviesDataSource: MoviesDataSource) :
    Fragment(R.layout.fragment_movie_list), MovieListAdapter.Interaction {

    lateinit var listAdapter: MovieListAdapter

    override fun onItemSelected(position: Int, item: Movie) {
        activity?.run {
            val bundle = Bundle()
            bundle.putInt("movie_id", item.id)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieDetailFragment::class.java, bundle)
                .addToBackStack("MovieDetailFragment")
                .commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getData()
    }

    private fun getData() {
        listAdapter.submitList(moviesDataSource.getMovies())
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)

            listAdapter = MovieListAdapter(this@MovieListFragment)
            adapter = listAdapter
        }
    }

}