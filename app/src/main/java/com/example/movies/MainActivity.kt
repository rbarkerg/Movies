package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
		setOnClick()
    }

    fun initUI() {
        movieRecycler.adapter = adapter
        movieRecycler.layoutManager = GridLayoutManager(this,2)
    }

    fun callAPI() {
        var movie1 = MMovie(identifier = 1, thumbnail = "https://i.ebayimg.com/images/g/XPwAAOSw3WxaEjBR/s-l400.jpg", name = "Cars 1",
        banner = "https://img.culturacolectiva.com/cdn-cgi/image/f=auto,w=1600,q=80,fit=contain/content_image/2018/11/26/1543256954192-primera-pelicula-de-cars-1.jpg",
            description = "El aspirante a campeón de carreras Rayo McQueen parece que está a punto de conseguir el éxito. Su actitud arrogante se desvanece cuando llega a una pequeña comunidad olvidada que le enseña las cosas importantes de la vida que había olvidado")
        var movie2 = MMovie(identifier = 2, thumbnail = "https://images-na.ssl-images-amazon.com/images/I/51+-cn8wfcL._SX258_BO1,204,203,200_.jpg", name = "Mulan",
        banner = "https://lh3.googleusercontent.com/proxy/hK2u0hsaejv609JXsJEwUAWrg3-UMzmsYQRvKzFAjMX0ASb4tJ2lpIavFm2YAWOmlonALhc_paEWM6Ed5jBnVbIiAGzDME8afj4ADRTcbL6-oCv2ywVbaJlN--kU-ktNr7F0V0kIVueM4Flv5YJLI7IDAb1hulAooXbKLJk6XuhwyKlmK2C_pUpBUS4xGW5ehPorDHbyOhmbdPbX5uSdjgMtc7CKPhvSrljf",
            description = "El emperador chino emite un decreto que exige que cada hogar debe reclutar a un varón para luchar con el ejército imperial en la guerra contra los Hunos. Para salvar a su anciano padre de este deber, su única hija Fa Mulan se hace pasar por soldado y toma su lugar")
        var movie3 = MMovie(identifier = 3, thumbnail = "https://lh3.googleusercontent.com/proxy/v2EaMmJfgsofpD4P-P7BC55YZMlZjDwemHDATZEWbfwJVlVJvjczkno9fu-Onb6EcIwPd3dReQvEmhbeV-VeWWyqBE1kn79bmdyosr40YntnFOCsEWgD8taj0BL9TAfVgzSh5Q", name = "Toys Story 3",
        banner = "https://i.ytimg.com/vi/0i5d2oBCYE4/maxresdefault.jpg",
            description = "Cuando su dueño Andy se prepara para ir a la universidad, el vaquero Woody, el astronauta Buzz y el resto de sus amigos juguetes comienzan a preocuparse por su incierto futuro. Todos acaban en una guardería donde comenzarán una serie de trepidantes y divertidas aventuras.")
        var movie4 = MMovie(identifier = 4, thumbnail = "https://es.web.img2.acsta.net/pictures/210/113/21011380_20130610122552563.jpg", name = "Aviones",
        banner= "https://i.ytimg.com/vi/p9z2EPmv73g/maxresdefault.jpg",
            description = "Dusty es el avión de un pueblo que sueña un día participar en competencia de gran velocidad. Sin embargo, el pobre Dusty tiene las probabilidades en su contra: Él no está construido para correr y le teme mucho a las alturas. Para conseguir su sueño, Dusty acude con el aviador naval Skipper. Skipper ayuda a Dusty a calificar a la Ripslinger, el circuito de carreras del campeón defensor. El coraje de Dusty enfrenta una gran prueba, al volar en alturas que nunca soñó que fueran posibles.")
        adapter.items = listOf(movie1,movie2, movie3, movie4)
        adapter.notifyDataSetChanged()
    }

    fun setOnClick()
    {
        adapter.onItemClick = {
            Log.d("==>", "${it.name}")
            val intent = Intent(this, Movie_detail::class.java)
            intent.putExtra("Movie", it)
            startActivity(intent)
        }
    }
}
