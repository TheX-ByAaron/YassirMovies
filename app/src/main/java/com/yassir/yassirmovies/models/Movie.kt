package com.yassir.yassirmovies.models

data class Movie(
    var id: Int,
    var title: String,
    var voteAverage: Double,
    var overview: String,
    var releaseDate: String,
    var backDropPath: String,
    var posterPath: String
)

data class MovieResult(
    var page: String,
    var movies: ArrayList<Movie>
)
