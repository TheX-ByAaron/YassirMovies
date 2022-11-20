package com.yassir.yassirmovies.models

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("vote_average")
    var voteAverage: Double,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("backdrop_path")
    var backDropPath: String,

    @SerializedName("poster_path")
    var posterPath: String
)

data class MovieResult(

    @SerializedName("page")
    var page: String,

    @SerializedName("results")
    var movies: ArrayList<Movie>
)
