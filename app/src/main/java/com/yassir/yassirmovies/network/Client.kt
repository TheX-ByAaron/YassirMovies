package com.yassir.yassirmovies.network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*

object Client {

    const val baseUrl = "api.themoviedb.org/3/"

    const val apiKey = "c9856d0cb57c3f14bf75bdc6c063b8f3"

    const val baseImageUrl = "https://image.tmdb.org/t/p/original/"

    private val client = HttpClient(OkHttp){
        developmentMode = true
        install(HttpCache)
        install(ContentNegotiation){
            gson()
        }
    }

    fun instance(): HttpClient = client

}