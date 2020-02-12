package com.example.popularmovieskotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.popularmovieskotlin.network.MovieClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val mTitle : TextView = findViewById(R.id.tv_title)
        val mRatingBar: RatingBar = findViewById(R.id.rb_rating)
        val mMovieImage: ImageView = findViewById(R.id.iv_poster)
        val mOverview: TextView = findViewById(R.id.tv_overview)

        val MOVIE_KEY = "movie"

        val key = intent.getIntExtra(MOVIE_KEY, 0)

        val errorContainer = error_container

        val client : MovieClient? = retrofitInstance()

        val popularCall: Call<DetailsModel?> = client!!.getDetails(key.toString(), API_KEY)

        popularCall.enqueue(object : Callback<DetailsModel?> {


            override fun onResponse(call: Call<DetailsModel?>, response: Response<DetailsModel?>) {

                val details: DetailsModel? = response.body()

                mOverview.text = details!!.overview
                val rating = details!!.voteAverage
                mRatingBar.rating = rating!!.toFloat()
                mTitle.text = details.title

                val fullMovieUrlPath: String =
                    BASE_IMAGE_URL + BASE_FILE_SIZE_SMALL + details.posterPath

                Picasso.get().load(fullMovieUrlPath).into(mMovieImage)


            }

            override fun onFailure(call: Call<DetailsModel?>, t: Throwable) {

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
}
