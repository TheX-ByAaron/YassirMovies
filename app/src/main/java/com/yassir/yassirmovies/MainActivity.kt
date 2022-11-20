package com.yassir.yassirmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.*
import com.yassir.yassirmovies.ui.composables.BottomBar
import com.yassir.yassirmovies.ui.composables.NavRoute
import com.yassir.yassirmovies.ui.screens.*
import com.yassir.yassirmovies.ui.theme.YassirMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {

            val navController = rememberNavController()
            val currentBackStack by navController.currentBackStackEntryAsState()

            val routes = arrayListOf(
                NavRoute(R.drawable.ic_shows, "shows"),
                NavRoute(R.drawable.ic_movies, "movies")
            )

            YassirMoviesTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding(),
                    color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {},
                        content = {
                            NavHost(navController = navController, startDestination = "OnBoarding"){
                                composable("OnBoarding"){ OnBoardingScreen(navController = navController) }
                                composable("MovieDetails"){ MovieDetailsScreen(navController = navController)}
                                composable("TvShowDetails"){ TvShowDetailsScreen(navController = navController)}
                                navigation(startDestination = "movies", route = "Home" ){
                                    composable("movies"){ MoviesScreen(navController = navController) }
                                    composable("shows"){ ShowsScreen(navController = navController) }
                                }
                            }
                        },
                        bottomBar = {
                            AnimatedVisibility(currentBackStack?.destination?.parent?.route == "Home"){
                                BottomBar(navController = navController, Routes = routes)
                            }

                        }
                    )
                }
            }
        }
    }
}