package com.example.popularmovieskotlin

import com.google.gson.annotations.SerializedName

class MovieModel {

    @SerializedName("page")
    val page: Int? = null
    @SerializedName("total_results")
    val totalResults: Int? = null
    @SerializedName("total_pages")
    val totalPages: Int? = null
    @SerializedName("results")
    val results: List<Result>? = null

}

class Result {

    @SerializedName("popularity")
    val popularity: Double? = null
    @SerializedName("vote_count")

    val voteCount: Int? = null
    @SerializedName("video")

    val video: Boolean? = null
    @SerializedName("poster_path")

    val posterPath: String? = null
    @SerializedName("id")

    val id: Int? = null
    @SerializedName("adult")

    val adult: Boolean? = null
    @SerializedName("backdrop_path")

    val backdropPath: String? = null
    @SerializedName("original_language")

    val originalLanguage: String? = null
    @SerializedName("original_title")

    val originalTitle: String? = null
    @SerializedName("genre_ids")

    val genreIds: List<Int>? = null
    @SerializedName("title")

    val title: String? = null
    @SerializedName("vote_average")

    val voteAverage: Double? = null
    @SerializedName("overview")

    val overview: String? = null
    @SerializedName("release_date")

    val releaseDate: String? = null

}

class DetailsModel {

    @SerializedName("adult")
    val adult: Boolean? = null
    @SerializedName("backdrop_path")
    val backdropPath: String? = null
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any? = null
    @SerializedName("budget")
    val budget: Int? = null
    @SerializedName("genres")
    val genres: List<Genre>? = null
    @SerializedName("homepage")
    val homepage: String? = null
    @SerializedName("id")
    val id: Int? = null
    @SerializedName("imdb_id")
    val imdbId: String? = null
    @SerializedName("original_language")
    val originalLanguage: String? = null
    @SerializedName("original_title")
    val originalTitle: String? = null
    @SerializedName("overview")
    val overview: String? = null
    @SerializedName("popularity")
    val popularity: Double? = null
    @SerializedName("poster_path")
    val posterPath: String? = null
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>? = null
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>? = null
    @SerializedName("release_date")
    val releaseDate: String? = null
    @SerializedName("revenue")
    val revenue: Int? = null
    @SerializedName("runtime")
    val runtime: Int? = null
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>? = null
    @SerializedName("status")
    val status: String? = null
    @SerializedName("tagline")
    val tagline: String? = null
    @SerializedName("title")
    val title: String? = null
    @SerializedName("video")
    val video: Boolean? = null
    @SerializedName("vote_average")
    val voteAverage: Double? = null
    @SerializedName("vote_count")
    val voteCount: Int? = null

}

class ProductionCountry {

}

class SpokenLanguage {

}

class Genre {

}