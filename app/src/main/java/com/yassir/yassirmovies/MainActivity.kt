package com.yassir.yassirmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yassir.yassirmovies.ui.screens.HomeScreen
import com.yassir.yassirmovies.ui.screens.MovieDetailsScreen
import com.yassir.yassirmovies.ui.screens.OnBoardingScreen
import com.yassir.yassirmovies.ui.screens.TvShowDetailsScreen
import com.yassir.yassirmovies.ui.theme.YassirMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            YassirMoviesTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    NavHost(navController = navController, startDestination = "OnBoarding"){
                        composable("OnBoarding"){ OnBoardingScreen(navController = navController) }
                        composable("Home"){ HomeScreen(navController = navController)}
                        composable("MovieDetails"){ MovieDetailsScreen(navController = navController)}
                        composable("TvShowDetails"){ TvShowDetailsScreen(navController = navController)}
                    }

                }
            }
        }
    }
}