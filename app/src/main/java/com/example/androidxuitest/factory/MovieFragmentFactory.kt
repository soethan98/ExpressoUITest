package com.example.androidxuitest.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.androidxuitest.ui.movie.DirectorsFragment
import com.example.androidxuitest.ui.movie.MovieDetailFragment
import com.example.androidxuitest.ui.movie.StarActorsFragment

class MovieFragmentFactory : FragmentFactory() {

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MovieDetailFragment::class.java.name -> MovieDetailFragment()
            DirectorsFragment::class.java.name -> DirectorsFragment()
            StarActorsFragment::class.java.name -> StarActorsFragment()
            else -> super.instantiate(classLoader, className)

        }
    }

}