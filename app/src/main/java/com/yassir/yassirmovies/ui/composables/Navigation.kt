package com.yassir.yassirmovies.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yassir.yassirmovies.ui.theme.navColor


data class NavRoute(var icon: Int = 0,var Route:String)

@Composable
fun BottomBar(navController: NavController, Routes : ArrayList<NavRoute>){

    val isSelected = navController.currentBackStackEntryAsState()

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

        Row(modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .height(72.dp)
            .background(color = MaterialTheme.colors.surface,
                shape = MaterialTheme.shapes.medium)
            .padding(top = 5.dp, bottom = 5.dp)
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceEvenly) {

            Routes.forEachIndexed { _, route ->

                BottomBarItem(modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 2.dp)
                    .fillMaxHeight()
                    .weight(1f)
                    , isSelected = isSelected.value?.destination?.route == route.Route
                    , icon = route.icon
                    , onNavigate = {
                        navController.navigate(route.Route) {
                            launchSingleTop = true
                            popUpTo("Home")
                            restoreState = true
                        }
                    }
                )

            }

        }

    }
}

@Composable
fun BottomBarItem(modifier :Modifier = Modifier
                  , isSelected: Boolean
                  , icon: Int
                  , onNavigate : ()-> Unit = {}){

    val selectedBarColor by animateColorAsState(targetValue = MaterialTheme.colors.primary)
    val itemSelectedColor by animateColorAsState(targetValue = MaterialTheme.colors.navColor)

    Column(modifier= modifier
        .background(
            if (isSelected) itemSelectedColor else MaterialTheme.colors.surface,
            shape = MaterialTheme.shapes.medium)
        .clip(shape = MaterialTheme.shapes.medium)
        .clickable {
            onNavigate()
        }

        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center){

        Icon(modifier = Modifier
            .padding(all = 0.dp)
            .size(30.dp)
            , painter = painterResource(id = icon)
            , contentDescription = "Bottom bar item"
            , tint = if(isSelected) selectedBarColor else MaterialTheme.colors.onSurface)

        AnimatedVisibility(visible = isSelected) {
            Surface(modifier = Modifier
                .padding(top = 6.dp)
                .height(5.dp)
                .width(5.dp)
                ,color = selectedBarColor
                , shape = MaterialTheme.shapes.medium){}
        }

    }
}