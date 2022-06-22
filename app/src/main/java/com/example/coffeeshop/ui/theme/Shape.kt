package com.example.coffeeshop.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

val Shapes = Shapes(

    small = CutCornerShape(
        topStart = 25.dp,
        topEnd = 25.dp,
        bottomEnd = 25.dp,
        bottomStart = 25.dp
    ),
    medium = RoundedCornerShape(
        topStart = 25.dp,
        topEnd = 0.dp,
        bottomEnd = 25.dp,
        bottomStart = 0.dp
    ),
    large = CutCornerShape(
        topStart = 35.dp,
        topEnd = 35.dp,
        bottomEnd = 35.dp,
        bottomStart = 35.dp
    )
)