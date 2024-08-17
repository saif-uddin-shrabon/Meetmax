package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.diagonalGradientBorder(
    colors: List<Color>,
    borderSize: Dp = 2.dp,
    shape: Shape,
    isFromRight: Boolean = false
) = composed {

    val (start, end) = if (isFromRight) {
        Pair(
            Offset(100f, 0.0f),
            Offset(0.0f, 100.0f)
        )
    } else {
        Pair(Offset.Zero, Offset.Infinite)
    }

    border(
        width = borderSize,
        brush = Brush.linearGradient(colors = colors, start = start, end = end),
        shape = shape
    )
}