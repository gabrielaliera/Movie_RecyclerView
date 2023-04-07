package com.example.movie_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var movieList: MutableList<JSONObject>
    private lateinit var rvMovies: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.movie_list)
        movieList = mutableListOf()
        getMovieInfo()
    }

    private fun getMovieInfo() {
        val client = AsyncHttpClient()

        val apiKEY = getString(R.string.API_KEY)


        client["https://api.themoviedb.org/3/trending/movie/day?api_key=$apiKEY&language=en-US", object :
            JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {
                Log.d("Movie Success", "$json")
                val movieResults = json.jsonObject.getJSONArray("results")
                Log.d("Movie Array", "$movieResults")

                for (i in 0 until movieResults.length()) {
                    movieList.add(movieResults.getJSONObject(i))
                }

                val adapter = MovieAdapter(movieList)
                rvMovies.adapter = adapter
                rvMovies.layoutManager = LinearLayoutManager(this@MainActivity)
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