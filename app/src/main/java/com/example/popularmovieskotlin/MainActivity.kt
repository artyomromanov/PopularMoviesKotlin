package com.example.popularmovieskotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.popularmovieskotlin.network.MovieClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnViewClickListener, ViewInterface {

    val MOVIE_KEY = "movie"

    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val errorContainer = error_container

        val recyclerView: RecyclerView = findViewById(R.id.rv_movies)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val client: MovieClient? = retrofitInstance()

        val popularCall: Call<MovieModel> = client!!.getMovies(API_KEY)

        popularCall.enqueue(object : Callback<MovieModel?> {


            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {

                val pulledModel: MovieModel? = response.body()

                val adapter = MovieAdapter(pulledModel!!, this@MainActivity)

                recyclerView.adapter = adapter

            }

            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {


            }

        })

    }

    private fun retrofitInstance(): MovieClient? {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MovieClient::class.java)

    }

    override fun onRecyclerItemClicked(movieID: Int) {

        val intent = Intent(this@MainActivity, DetailsActivity::class.java)

        intent.putExtra(MOVIE_KEY, movieID)

        startActivity(intent)
    }

    override fun displayMovies(moviesList: List<MovieModel>) {

        presenter.callRetrofit()

    }

    override fun showError(t: Throwable) {

        error_container.visibility = View.VISIBLE

    }
}

