package com.yassir.yassirmovies.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


data class NavRoute(var icon: Int = 0,var Route:String)

@Composable
fun BottomBar(navController: NavController, Routes : ArrayList<NavRoute>){

    val isSelected = navController.currentBackStackEntryAsState()

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

        Row(modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = MaterialTheme.colors.surface, shape = MaterialTheme.shapes.medium
            )
            .padding(top = 5.dp, bottom = 5.dp)

            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceEvenly) {

            Routes.forEachIndexed { _, route ->
                Box(modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .clickable {
                        navController.navigate(route.Route) {
                            launchSingleTop = true
                            popUpTo("Home")
                            restoreState = true
                        }
                    }){
                    BottomBarItem(isSelected.value?.destination?.route == route.Route,route.icon)
                }
            }

        }

    }
}

@Composable
fun BottomBarItem(isSelected: Boolean,
                  icon: Int){
    val selectedBarColor by animateColorAsState(targetValue = MaterialTheme.colors.primaryVariant)
    val itemSelectedColor by animateColorAsState(targetValue = MaterialTheme.colors.surface)

    Column(modifier= Modifier
        .requiredWidth(50.dp)
        .height(50.dp)
        .background(
            if (isSelected) itemSelectedColor else MaterialTheme.colors.surface,
            shape = MaterialTheme.shapes.small
        )
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = if(isSelected) Arrangement.SpaceBetween else Arrangement.Center){

        Image(modifier = Modifier
            .padding(all = 8.dp)
            .size(30.dp)
            , painter = painterResource(id = icon)
            , contentDescription = "Bottom bar item"
            , colorFilter = ColorFilter.tint(if(isSelected) selectedBarColor else MaterialTheme.colors.primary))

        AnimatedVisibility(visible = isSelected) {
            Surface(modifier = Modifier
                .height(5.dp)
                .width(35.dp)
                ,color = selectedBarColor
                , shape = MaterialTheme.shapes.medium){}
        }

    }
}


fun NavController.navigateTo(route: String){
    this.navigate(route){
        launchSingleTop = true
        restoreState = true
    }
}