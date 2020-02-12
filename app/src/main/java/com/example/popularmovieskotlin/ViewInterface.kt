package com.example.popularmovieskotlin

interface ViewInterface {

    fun displayMovies(moviesList : List<MovieModel>) {}

    fun showError(t : Throwable) {}

}