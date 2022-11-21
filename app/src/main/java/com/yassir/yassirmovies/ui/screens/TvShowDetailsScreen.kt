package com.yassir.yassirmovies.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.yassir.yassirmovies.ui.theme.background_100
import com.yassir.yassirmovies.ui.theme.background_50
import com.yassir.yassirmovies.ui.theme.background_80
import com.yassir.yassirmovies.viewmodels.MainViewModel


@Composable
fun TvShowDetailsScreen(showId: String,
                        navController: NavController,
                        mainViewModel: MainViewModel = viewModel()){

    val background = Brush.verticalGradient(
        listOf(
            Color.Transparent,
            MaterialTheme.colors.background_50,
            MaterialTheme.colors.background_80,
            MaterialTheme.colors.background_80,
            MaterialTheme.colors.background_100)
    )

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(model = R.drawable.cover
                , contentDescription = "Cover image"
                , contentScale = ContentScale.Crop
                , alignment = Alignment.Center
                , modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp))

            Surface(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                , color = Color.Transparent) {}
        }

        Column(modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
            .background(brush = background)
            , horizontalAlignment = Alignment.CenterHorizontally) {

            AsyncImage(model = R.drawable.cover
                , contentDescription = "poster image"
                , contentScale = ContentScale.Crop
                , alignment = Alignment.Center
                , modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 42.dp)
                    .height(300.dp)
                    .width(200.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .shadow(10.dp))

            Text(text = "The shawnsShank redemption"
                , textAlign = TextAlign.Center
                , fontWeight = FontWeight.Bold
                , fontSize = 28.sp
                , modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight())

            Text(text = "1994"
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
                .background(color = MaterialTheme.colors.primary,
                    shape = MaterialTheme.shapes.small)
                .padding(horizontal = 4.dp, vertical = 8.dp)
                , verticalAlignment = Alignment.CenterVertically
                , horizontalArrangement = Arrangement.Center) {

                Icon(painter = painterResource(id = R.drawable.ic_likes)
                    , contentDescription = ""
                    , tint = Color.White
                    , modifier = Modifier.size(25.dp))

                Text(text = "10"
                    , fontWeight = FontWeight.Medium
                    , fontSize = 14.sp
                    , color = Color.White
                    , modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .wrapContentSize())
            }

            Text(text = "A text goes here, this is a long text to represent the description of the movie that will be instated here after a request from the client to the server"
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