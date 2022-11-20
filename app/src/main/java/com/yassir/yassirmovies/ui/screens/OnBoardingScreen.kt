package com.yassir.yassirmovies.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.yassir.yassirmovies.R
import com.yassir.yassirmovies.ui.composables.TextButton
import com.yassir.yassirmovies.ui.theme.background_100
import com.yassir.yassirmovies.ui.theme.background_50
import com.yassir.yassirmovies.ui.theme.background_80



@Composable
fun OnBoardingScreen(navController: NavController){


    val background = Brush.verticalGradient(
        listOf(
            Color.Transparent,
            MaterialTheme.colors.background_50,
            MaterialTheme.colors.background_80,
            MaterialTheme.colors.background_100,

        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(model = R.drawable.cover
            , contentDescription = "App cover"
            , contentScale = ContentScale.Crop
            , alignment = Alignment.Center
            , modifier = Modifier.fillMaxSize())

        Column(modifier = Modifier
            .fillMaxSize()
            .background(brush = background)
            , horizontalAlignment = Alignment.CenterHorizontally) {


            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)){}

            AsyncImage(model = R.drawable.main_logo
                , contentDescription = "Main logo"
                , modifier = Modifier
                    .padding(horizontal = 48.dp, vertical = 0.dp)
                    .fillMaxWidth()
                    .wrapContentHeight())
            
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                , horizontalAlignment = Alignment.CenterHorizontally
                , verticalArrangement = Arrangement.Center) {
                
                Text(modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 24.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    , text = "Explore the first ever algerian streaming service, brought to you by Yassir."
                    , color = Color.White
                    , fontSize = 20.sp
                    , textAlign = TextAlign.Center)

                TextButton(modifier = Modifier
                    .padding(horizontal = 0.dp, vertical = 0.dp)
                    .width(230.dp)
                    , text = "Explore"
                    , tint = MaterialTheme.colors.primary
                    , textTint = Color.White
                    , onClick = {
                        navController.navigate("Home"){
                            launchSingleTop = true
                            popUpTo("OnBoarding"){
                                this.inclusive = true
                            }
                            restoreState = true
                        }
                    })
            }
        }
    }
}

