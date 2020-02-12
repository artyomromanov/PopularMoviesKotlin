package com.example.popularmovieskotlin.network

import com.example.popularmovieskotlin.DETAILS_KEY
import com.example.popularmovieskotlin.DetailsModel
import com.example.popularmovieskotlin.MovieModel
import com.example.popularmovieskotlin.POPULAR_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieClient {

    @GET(POPULAR_KEY)
    fun getMovies(@Query("api_key") key: String?): Call<MovieModel>

     @GET(DETAILS_KEY)
     fun getDetails(@Path("movie_id") id: String?, @Query("api_key") key: String?): Call<DetailsModel?>
}