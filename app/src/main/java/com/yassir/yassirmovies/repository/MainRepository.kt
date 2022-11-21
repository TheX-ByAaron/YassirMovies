package com.yassir.yassirmovies.repository

import com.yassir.yassirmovies.models.Movie
import com.yassir.yassirmovies.models.MovieResult
import com.yassir.yassirmovies.models.Show
import com.yassir.yassirmovies.models.ShowResult
import com.yassir.yassirmovies.network.getMovieById
import com.yassir.yassirmovies.network.getMovies
import com.yassir.yassirmovies.network.getShowById
import com.yassir.yassirmovies.network.getShows
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

object MainRepository {

    suspend fun getShowsAsync() : Deferred<ShowResult?> {
        val deferred : Deferred<ShowResult?> = CoroutineScope(Dispatchers.IO).async {
            return@async getShows()
        }

        return deferred

    }

    suspend fun getMoviesAsync() : Deferred<MovieResult?> {
        val deferred : Deferred<MovieResult?> = CoroutineScope(Dispatchers.IO).async {
            return@async getMovies()
        }

        return deferred

    }

    suspend fun getMovieDetailsAsync(id: String): Deferred<Movie?> {
        val deferred: Deferred<Movie?> = CoroutineScope(Dispatchers.IO).async {
            return@async getMovieById(id)
        }

        return deferred
    }

    suspend fun getShowDetailsAsync(id: String): Deferred<Show?> {
        val deferred: Deferred<Show?> = CoroutineScope(Dispatchers.IO).async {
            return@async getShowById(id)
        }

        return deferred
    }

}