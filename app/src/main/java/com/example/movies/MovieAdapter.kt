package com.example.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.Model.MMovie
import kotlinx.android.synthetic.main.activity_movie_cell.view.*

class MovieAdapter(var items : List<MMovie>, val adapterContext: Context) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var onItemClick: ((MMovie) -> Unit)? = null
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.activity_movie_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.showItem(items[position])
    }

    inner class ViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        fun showItem(movie: MMovie, itemView: View = view) {
            Glide.with(adapterContext).load(movie.thumbnail).centerCrop().into(itemView.thumbnail)
            itemView.movieName.text = movie.name
        }

        init {
            view!!.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
//        val tvAnimalType = view.tv_animal_type
    }

}