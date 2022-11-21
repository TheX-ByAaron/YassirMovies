package com.yassir.yassirmovies.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Green200 = Color(0xFFE0FFE2)
val Green500 = Color(0xFF00C70E)
val Green700 = Color(0xFF0B9711)

val Black = Color(0xFF111111)
val Black200 = Color(0xFF222222)

val Colors.navColor : Color
    get() = Color(0x1400C70E)

val Colors.background_100 : Color
    get() =  if(isLight) Green200 else Black