package com.example.coffeeshop.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.toArgb
import com.example.coffeeshop.ui.imageslist.ImageScreen
import com.example.coffeeshop.ui.theme.CoffeeShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeShopTheme {
                window.statusBarColor =
                    MaterialTheme.colors.primary.toArgb()
                    ImageScreen()

            }
        }
    }

}


