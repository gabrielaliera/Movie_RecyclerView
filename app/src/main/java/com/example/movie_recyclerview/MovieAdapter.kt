package com.example.movie_recyclerview

import android.view.LayoutInflater
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
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Get element from your dataset at this position and replace the contents of the view with that element")
    }

    override fun getItemCount() = movieList.size

}