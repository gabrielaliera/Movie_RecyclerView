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

        client["https://api.themoviedb.org/3/movie/76341?api_key=$API_KEY", object :
            JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {
                Log.d("Movie Success", "$json")
                val movieImageArray = json.jsonObject.getJSONArray("message")
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