package com.yassir.yassirmovies.network

import com.yassir.yassirmovies.models.Movie
import com.yassir.yassirmovies.models.MovieResult
import com.yassir.yassirmovies.models.ShowResult
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*


suspend fun getShows() : ShowResult? {
    val response = Client.instance().get {
        url {
            protocol =  URLProtocol.HTTPS
            host = Client.baseUrl
            path("/discover/tv")
            parameters.append("api_key", Client.apiKey)
        }
    }

    return if(response.status == HttpStatusCode.OK){
        response.body()
    }else{
        null
    }
}

suspend fun getMovies() : MovieResult? {
    val response = Client.instance().get {
        url {
            protocol =  URLProtocol.HTTPS
            host = Client.baseUrl
            path("/discover/movie")
            parameters.append("api_key", Client.apiKey)
        }
    }

    return if(response.status == HttpStatusCode.OK){
        response.body()
    }else{
        null
    }
}

suspend fun getMovieById(id: String): Movie? {
    val response = Client.instance().get {
        url {
            protocol =  URLProtocol.HTTPS
            host = Client.baseUrl
            path("/movie/${id}")
            parameters.append("api_key", Client.apiKey)
        }
    }

    return if(response.status == HttpStatusCode.OK){
        response.body()
    }else{
        null
    }
}