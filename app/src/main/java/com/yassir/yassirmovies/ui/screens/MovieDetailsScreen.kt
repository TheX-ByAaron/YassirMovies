package com.yassir.yassirmovies.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.yassir.yassirmovies.R
import com.yassir.yassirmovies.network.Client
import com.yassir.yassirmovies.ui.theme.background_100
import com.yassir.yassirmovies.viewmodels.MainViewModel

@Composable
fun MovieDetailsScreen(movieId: String,
                       navController: NavController,
                       mainViewModel: MainViewModel = viewModel()){

    val background = Brush.verticalGradient(
        listOf(
            Color.Transparent,
            MaterialTheme.colors.background_100,
            MaterialTheme.colors.background_100,
            MaterialTheme.colors.background_100,
            MaterialTheme.colors.background_100)
    )

    mainViewModel.getMovieDetails(movieId)
    val movie = mainViewModel.currentMovieDetails.observeAsState()

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(model = "${Client.baseImageUrl}${movie.value?.backDropPath}"
                , contentDescription = "Cover image"
                , contentScale = ContentScale.Crop
                , alignment = Alignment.Center
                , modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp))

            Surface(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                , color = Color.Transparent) {}
        }

        Column(modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(brush = background)
            , horizontalAlignment = Alignment.CenterHorizontally) {

            AsyncImage(model = "${Client.baseImageUrl}${movie.value?.posterPath}"
                , contentDescription = "poster image"
                , contentScale = ContentScale.Crop
                , alignment = Alignment.Center
                , modifier = Modifier
                    .padding(top = 65.dp, bottom = 24.dp)
                    .height(300.dp)
                    .width(200.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .shadow(10.dp))
            
            Text(text = movie.value?.title?: "..."
                , textAlign = TextAlign.Center
                , fontWeight = FontWeight.Bold
                , fontSize = 28.sp
                , modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight())

            Text(text = movie.value?.releaseDate?: "..."
                , textAlign = TextAlign.Center
                , fontWeight = FontWeight.SemiBold
                , color = MaterialTheme.colors.primary
                , fontSize = 20.sp
                , modifier = Modifier
                    .padding(horizontal = 0.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight())

            Row(modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 8.dp)
                .wrapContentSize()
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = MaterialTheme.shapes.small
                )
                .padding(horizontal = 4.dp, vertical = 8.dp)
                , verticalAlignment = Alignment.CenterVertically
                , horizontalArrangement = Arrangement.Center) {

                Icon(painter = painterResource(id = R.drawable.ic_likes)
                    , contentDescription = ""
                    , tint = Color.White
                    , modifier = Modifier.size(25.dp))

                Text(text = movie.value?.voteAverage?.toString()?: "..."
                    , fontWeight = FontWeight.Medium
                    , fontSize = 14.sp
                    , color = Color.White
                    , modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .wrapContentSize())
            }

            Text(text = movie.value?.overview?: "..."
                , textAlign = TextAlign.Justify
                , fontWeight = FontWeight.Normal
                , fontSize = 18.sp
                , modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight())

        }
    }
}