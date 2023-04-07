package com.example.movie_recyclerview

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter (private val movieList: List<String>): RecyclerView.Adapter<MovieAdapter.ViewHolder>( ){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieImage: ImageView

        init {
            // Find our RecyclerView item's ImageView for future use
            movieImage = view.findViewById(R.id.movie_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}