package com.yassir.yassirmovies.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yassir.yassirmovies.ui.composables.ShowCard
import com.yassir.yassirmovies.viewmodels.MainViewModel

@Composable
fun ShowsScreen(navController: NavController
    ,mainViewModel: MainViewModel = viewModel()){

    val background = Brush.verticalGradient(
        listOf(
            MaterialTheme.colors.primaryVariant,
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
        )
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(background)
        .statusBarsPadding()) {

        Text(text = "Discover our shows"
            , fontSize = 28.sp
            , fontWeight = FontWeight.Bold
            , modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 16.dp))

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.medium)){

            items(15){
                ShowCard()
            }

            item {
                Surface(modifier = Modifier.fillMaxWidth().height(120.dp)
                    , color = MaterialTheme.colors.background) {}
            }
        }
    }
}