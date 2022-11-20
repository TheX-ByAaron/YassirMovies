package com.yassir.yassirmovies.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yassir.yassirmovies.R
import com.yassir.yassirmovies.ui.composables.BottomBar
import com.yassir.yassirmovies.ui.composables.NavRoute
import com.yassir.yassirmovies.viewmodels.MainViewModel

@Composable
fun HomeScreen(navController: NavHostController,
               mainViewModel: MainViewModel = viewModel()){

    val routes = arrayListOf(
        NavRoute(R.drawable.ic_shows, "shows"),
        NavRoute(R.drawable.ic_movies, "movies")
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            bottomBar = {
                BottomBar(navController = navController, Routes = routes)
            },
            content = { paddingValues ->
                NavHost(modifier = Modifier.padding(paddingValues)
                    , navController = navController
                    , startDestination = "movies" ){

                    composable("movies"){ Text(text = "movies")}
                    composable("shows"){ Text(text = "shows") }
                }
            }

        )
    }
}