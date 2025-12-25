package com.example.kmp_train

import androidx.compose.ui.graphics.Color

fun Colors.toColor(): Color {
    return when (this) {
        Colors.BLUE -> Color.Blue
        Colors.RED -> Color.Red
        Colors.GREEN -> Color.Green
    }
}