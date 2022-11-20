package com.yassir.yassirmovies.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun TextButton(modifier: Modifier = Modifier
               , tint: Color = MaterialTheme.colors.primary
               , textTint : Color = MaterialTheme.colors.onSurface
               , text : String = "button"
               , onClick : () -> Unit = {}){

    Box(modifier = modifier
        .clip(MaterialTheme.shapes.small)
        .clickable { onClick() }
        .background(tint)
        .padding(horizontal = 8.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center){

        Text(text = text
            , color = textTint
            , fontWeight = FontWeight.SemiBold
            , fontSize = 18.sp)

    }
}