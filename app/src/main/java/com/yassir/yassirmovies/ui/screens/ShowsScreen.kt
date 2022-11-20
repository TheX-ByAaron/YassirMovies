package com.yassir.yassirmovies.ui.screens

import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current

    mainViewModel.getShows()
    val shows = mainViewModel.showList.observeAsState()

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

            if(shows.value != null){
                items(shows.value?.toList()!!){ show ->
                    ShowCard(show){
                        navController.navigate("TvShowDetails/${show.id}")
                    }
                }
            }

            item {
                Surface(modifier = Modifier.fillMaxWidth().height(120.dp)
                    , color = Color.Transparent) {}
            }
        }
    }
}