package com.example.movie_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
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

        //Another call to add year search
        // "https://api.themoviedb.org/3/discover/movie?api_key=$apiKEY&certification_country=US&certification.lte=R&sort_by=popularity.desc&primary_release_year=2023"

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

                //Add rounded corners
                val divider = ResourcesCompat.getDrawable(resources, R.drawable.movie_item, null)
                val itemDecoration = DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
                itemDecoration.setDrawable(divider!!)
                rvMovies.addItemDecoration(itemDecoration)



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