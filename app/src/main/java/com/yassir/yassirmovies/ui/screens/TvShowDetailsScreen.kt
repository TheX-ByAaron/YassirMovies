package com.yassir.yassirmovies.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yassir.yassirmovies.viewmodels.MainViewModel


@Composable
fun TvShowDetailsScreen(showId: String,
                        navController: NavController,
                        mainViewModel: MainViewModel = viewModel()){

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "shows")
    }
}