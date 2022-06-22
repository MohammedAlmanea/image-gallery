package com.example.coffeeshop.ui.imageslist

import com.example.coffeeshop.data.domin.Image

data class ImageListState(
    val isLoading: Boolean =false
    ,val error: String = ""
    ,val images: List<Image> = emptyList()
)
