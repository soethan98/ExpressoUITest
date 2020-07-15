package com.example.androidxuitest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidxuitest.R
import com.example.androidxuitest.factory.MovieFragmentFactory
import com.example.androidxuitest.ui.movie.MovieDetailFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MovieFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }


    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id",movieId)
            supportFragmentManager.beginTransaction().replace(R.id.container,MovieDetailFragment::class.java
            ,bundle).commit()
        }
    }
}