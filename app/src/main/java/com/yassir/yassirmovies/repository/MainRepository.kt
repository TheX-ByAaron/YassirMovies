package com.yassir.yassirmovies.repository

import com.yassir.yassirmovies.models.Show
import com.yassir.yassirmovies.models.ShowResult
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

}