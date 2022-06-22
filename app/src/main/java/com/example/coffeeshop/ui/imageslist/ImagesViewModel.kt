package com.example.coffeeshop.ui.imageslist

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.R
import com.example.coffeeshop.common.Response
import com.example.coffeeshop.data.domin.Image
import com.example.coffeeshop.data.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val repository: ImageRepository
)
    : ViewModel() {
    private val _state = mutableStateOf(ImageListState())
    val state : State<ImageListState> =_state
    init {
        getImages()
    }
    fun getImages()
    {
        repository.getAllImages().onEach {
            when (it) {
                is Response.Loading -> {
                    _state.value = ImageListState(isLoading = true)
                }
                is Response.Success -> {

                    _state.value = ImageListState(images = it.data ?: emptyList())
                }
                is Response.Error -> {
                    _state.value = ImageListState(error = it.message ?: "error")
                }

            }
        }.launchIn(viewModelScope)
    }
}