package com.example.androidxuitest.ui.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidxuitest.R
import kotlinx.android.synthetic.main.fragment_start_actor.*


class StarActorsFragment : Fragment(R.layout.fragment_start_actor){
    private val starActors: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            starActors.addAll(args.get("args_actors") as List<String>)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActors()
    }



    private fun setActors(){
        star_actors_text.text = stringBuilderForStarActors(starActors)
    }

    companion object{
        fun stringBuilderForStarActors(actors: ArrayList<String>): String{
            val sb = StringBuilder()
            for(actor in actors){
                sb.append(actor + "\n")
            }
            return sb.toString()
        }
    }
}