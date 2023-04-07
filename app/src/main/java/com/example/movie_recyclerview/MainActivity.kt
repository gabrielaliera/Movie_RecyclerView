package com.example.movie_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMovieInfo()
    }

    private fun getMovieInfo() {
        val client = AsyncHttpClient()

        val API_KEY = getString(R.string.API_KEY)
        Log.d("Movie API", "$API_KEY")

        client["https://api.themoviedb.org/3/trending/movie/day?api_key=$API_KEY&language=en-US", object :
            JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {
                Log.d("Movie Success", "$json")
                val movieResults = json.jsonObject.getJSONArray("results")
                Log.d("Movie Array", "$movieResults")
                val firstMovie = movieResults.getJSONObject(0)
                Log.d("Movie 1st", "$firstMovie")
                val title = firstMovie.getString("title")
                val voteAverage = firstMovie.getString("vote_average")
                Log.d("Movie Title/Average", "$title  $voteAverage")
                val image = "https://image.tmdb.org/t/p/w500/" + firstMovie.getString("poster_path")
                Log.d("Movie Image", "$image")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Movie Error", errorResponse)
            }
        }]
    }
}