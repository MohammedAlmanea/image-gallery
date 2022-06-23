package com.example.coffeeshop.ui.imageslist

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffeeshop.ImageCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageScreen(viewModel: ImagesViewModel = hiltViewModel() )
{
    val state = viewModel.state.value
    Surface(
        modifier = Modifier.fillMaxSize()
            ,color = MaterialTheme.colors.secondaryVariant
    )
    {
        if (state.isLoading || state.error.isNotEmpty()) {
            // both error and isLoading need a box to align content
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            )
            {
                if (state.isLoading)
                    CircularProgressIndicator()
                if (state.error.isNotEmpty())
                    Text(text = state.error)
            }
        } else { //then state is success

            LazyVerticalGrid(
                cells = GridCells.Adaptive(150.dp),
                modifier = Modifier.background(MaterialTheme.colors.secondaryVariant)
            )
            {
                item(span = { GridItemSpan(5) })
                {


                    Box()
                    {
                        Box(
                            Modifier
                                .width(350.dp)
                                .height(120.dp)
                                .clip(MaterialTheme.shapes.large)
                                .align(Alignment.Center)
                        )
                        {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(vertical = 16.dp)
                                    .background(MaterialTheme.colors.primaryVariant),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {
                                Text(
                                    text = "Welcome to my images gallery",
                                    style = MaterialTheme.typography.caption
                                )
                                Text(
                                    text = "( ﾉ ﾟｰﾟ)ﾉ＼(ﾟｰﾟ＼)",
                                    style = MaterialTheme.typography.caption
                                )

                            }
                        }
                    }
                }
                items(
                    state.images
                )
                {
                    Log.e("ImagesScreen", "${state.images}")
                    ImageCard(it)
                }
            }

        }
    }
}