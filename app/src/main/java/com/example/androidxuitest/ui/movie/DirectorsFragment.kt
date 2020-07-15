package com.example.androidxuitest.ui.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidxuitest.R
import kotlinx.android.synthetic.main.fragment_directors.*

class DirectorsFragment : Fragment(R.layout.fragment_directors) {

    private val directors: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            directors.addAll(args.get("args_directors") as List<String>)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDirectors()
    }

    private fun setDirectors() {
            directors_text.text = stringBuilderForDirectors(directors)
    }

    companion object {
        fun stringBuilderForDirectors(directors: ArrayList<String>): String {
            val sb = StringBuilder()
            for (director in directors) {
                sb.append(director + "\n")
            }
            return sb.toString()
        }
    }
}