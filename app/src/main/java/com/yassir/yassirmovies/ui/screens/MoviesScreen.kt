package com.yassir.yassirmovies.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yassir.yassirmovies.viewmodels.MainViewModel

@Composable
fun MoviesScreen(navController: NavController
                ,mainViewModel: MainViewModel = viewModel()){

    Column(modifier = Modifier
        .statusBarsPadding()
        .fillMaxSize()) {


    }
}