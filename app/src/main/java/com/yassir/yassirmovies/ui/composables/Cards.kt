package com.yassir.yassirmovies.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.yassir.yassirmovies.R


@Composable
fun MovieCard(){

    Row(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .fillMaxWidth()
        .height(200.dp)
        .background(
            color = MaterialTheme.colors.surface,
            shape = MaterialTheme.shapes.medium
        )) {

        AsyncImage(model = R.drawable.cover
            , contentDescription = "Cover image"
            , contentScale = ContentScale.Crop
            , alignment = Alignment.Center
            , modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxHeight()
                .weight(0.9f)
                .clip(MaterialTheme.shapes.medium))

        Column(modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 0.dp)
            .fillMaxHeight()
            .weight(1.1f)) {

            Text(text = "The shawshank redemption"
                , fontWeight = FontWeight.Bold
                , fontSize = 20.sp
                , maxLines = 2
                , overflow = TextOverflow.Ellipsis
                , modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight())

            Text(text = "Aired: 1992"
                , fontWeight = FontWeight.Medium
                , fontSize = 16.sp
                , modifier = Modifier
                    .padding(horizontal = 0.dp, vertical = 4.dp)
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

                Text(text = "8.9"
                    , fontWeight = FontWeight.Medium
                    , fontSize = 14.sp
                    , color = Color.White
                    , modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .wrapContentSize())
            }
        }


    }
}


@Composable
fun ShowCard(){

    Row(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .fillMaxWidth()
        .height(200.dp)
        .background(
            color = MaterialTheme.colors.surface,
            shape = MaterialTheme.shapes.medium
        )) {

        AsyncImage(model = R.drawable.cover
            , contentDescription = "Cover image"
            , contentScale = ContentScale.Crop
            , alignment = Alignment.Center
            , modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxHeight()
                .weight(0.9f)
                .clip(MaterialTheme.shapes.medium))

        Column(modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 0.dp)
            .fillMaxHeight()
            .weight(1.1f)) {

            Text(text = "The shawshank redemption"
                , fontWeight = FontWeight.Bold
                , fontSize = 20.sp
                , maxLines = 2
                , overflow = TextOverflow.Ellipsis
                , modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight())

            Text(text = "Aired: 1992"
                , fontWeight = FontWeight.Medium
                , fontSize = 16.sp
                , modifier = Modifier
                    .padding(horizontal = 0.dp, vertical = 4.dp)
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

                Text(text = "8.9"
                    , fontWeight = FontWeight.Medium
                    , fontSize = 14.sp
                    , color = Color.White
                    , modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .wrapContentSize())
            }
        }


    }
}