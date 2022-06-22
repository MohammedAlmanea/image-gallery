package com.example.coffeeshop.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFFb7b7a4),
//    primary = Color.Red,
    primaryVariant = Color(0xFFa3b18a),
    secondary = Color(0xFFffe8d6),
    secondaryVariant = Color.DarkGray

)

private val LightColorPalette = lightColors(
    primary = Color(0xFF6b705c),
    primaryVariant = Color(0xFFa5a58d),
    secondary = Color(0xFFcb997e)
    , secondaryVariant = Color(0xFFf8ffff)
)

@Composable
fun CoffeeShopTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}