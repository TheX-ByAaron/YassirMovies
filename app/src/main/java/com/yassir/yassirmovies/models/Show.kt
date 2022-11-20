package com.yassir.yassirmovies.models

import com.google.gson.annotations.SerializedName

data class Show(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("vote_average")
    var voteAverage: Double,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("first_air_date")
    var airDate: String,

    @SerializedName("backdrop_path")
    var backDropPath: String,

    @SerializedName("poster_path")
    var posterPath: String
)

data class ShowResult(

    @SerializedName("page")
    var page: String,

    @SerializedName("results")
    var shows: ArrayList<Show>
)
