package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movies.Model.MMovie
import kotlinx.android.synthetic.main.activity_movie_cell.view.*
import kotlinx.android.synthetic.main.activity_movie_detail.*

class Movie_detail : AppCompatActivity() {

    var modelo = MMovie()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        initUI()
    }

    fun initUI()
    {
        modelo =  intent.getSerializableExtra("Movie") as MMovie
        Glide.with(this).load(modelo.banner).centerCrop().into(banner)
        description.text = modelo.description
    }
}
