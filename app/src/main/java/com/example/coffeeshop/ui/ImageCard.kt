package com.example.coffeeshop

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.data.domin.Image
import com.example.coffeeshop.ui.imageslist.NetworkImage

@Composable
fun ImageCard(pic1 : Image)
{
    Card(
        elevation = 15.dp,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .padding(vertical = 16.dp)
            .border(
                2.dp,
                MaterialTheme.colors.secondary.copy(alpha = 0.8f),
                MaterialTheme.shapes.small
            )
    ) {
        Box(modifier = Modifier.size(300.dp))
        {
            NetworkImage(
                url = pic1.downloadUrl,
                contentDesc =null,
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = pic1.author,
                modifier = Modifier
                    .fillMaxWidth()
//                    .background(Color.Black.copy(alpha = 0.3f))
                    .background(MaterialTheme.colors.secondary.copy(alpha = 0.6f))
                    .align(Alignment.BottomCenter),
                style = MaterialTheme.typography.caption
            )
        }
    }

}
