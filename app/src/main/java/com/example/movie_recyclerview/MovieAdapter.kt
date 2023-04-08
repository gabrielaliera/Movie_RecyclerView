package com.example.movie_recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.json.JSONObject

class MovieAdapter (private val movieList: List<JSONObject>): RecyclerView.Adapter<MovieAdapter.ViewHolder>( ){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieImage: ImageView
        val movieTitle: TextView
        val movieRating: TextView

        init {
            // Find our RecyclerView item's ImageView for future use
            movieImage = view.findViewById(R.id.movie_image)
            movieTitle = view.findViewById(R.id.movie_title)
            movieRating = view.findViewById(R.id.movie_rating)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       //Get element from your dataset at this position and replace the contents of the view with that element"

        //Add Toast
        val rank = position + 1
        holder.movieImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Number $rank movie clicked", Toast.LENGTH_SHORT).show()
        }
        //Grab movie info
        val movie = movieList[position]
        Log.d("Movie 1st", "$movie")

        //Get title and rating from json object
        val title = movie.getString("title")
        val voteAverage = movie.getString("vote_average")
        Log.d("Movie Title/Average", "$title  $voteAverage")

        //Set title and rating
        holder.movieTitle.text = "$rank: $title"
        holder.movieRating.text = "Average Rating: $voteAverage"


        //Get & Load Image
        val image = "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path")
        Log.d("Movie Image", "$image")

        Glide.with(holder.itemView)
            .load(image)
            .centerCrop()
            .into(holder.movieImage)
        Log.d("Movie Image", "success")
    }

    override fun getItemCount() = movieList.size

}