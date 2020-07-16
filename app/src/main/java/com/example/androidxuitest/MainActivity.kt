package com.example.androidxuitest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.ActivityResult
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

const val GALLERY_REQUEST_CODE = 1234

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        finish()
        button_open_gallery.setOnClickListener {
            pickFromGallery()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                GALLERY_REQUEST_CODE -> {
                    Log.d("MainActivity", "GALLERY_REQUEST_CODE detected.")

                    data?.data?.let { uri ->
                        Log.d("MainActivity", "URI: $uri")
                        Glide.with(this)
                            .load(uri)
                            .into(image)
                    }
                }
            }
        }
    }

    private fun pickFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }
}