package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.Model.MMovie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MovieAdapter(listOf(), this)
        initUI()
        callAPI()
    }

    fun initUI() {
        movieRecycler.adapter = adapter
        movieRecycler.layoutManager = GridLayoutManager(this,2)
    }

    fun callAPI() {
        var movie1 = MMovie(identifier = 1, thumbnail = "https://i.ebayimg.com/images/g/XPwAAOSw3WxaEjBR/s-l400.jpg", name = "Cars 1")
        var movie2 = MMovie(identifier = 2, thumbnail = "https://images-na.ssl-images-amazon.com/images/I/51+-cn8wfcL._SX258_BO1,204,203,200_.jpg", name = "Mulan")
        var movie4 = MMovie(identifier = 3, thumbnail = "https://lh3.googleusercontent.com/proxy/v2EaMmJfgsofpD4P-P7BC55YZMlZjDwemHDATZEWbfwJVlVJvjczkno9fu-Onb6EcIwPd3dReQvEmhbeV-VeWWyqBE1kn79bmdyosr40YntnFOCsEWgD8taj0BL9TAfVgzSh5Q", name = "Toys Story 3")
        var movie5 = MMovie(identifier = 4, thumbnail = "https://es.web.img2.acsta.net/pictures/210/113/21011380_20130610122552563.jpg", name = "Aviones")
        adapter.items = listOf(movie1,movie2, movie4, movie5)
        adapter.notifyDataSetChanged()
    }
}
