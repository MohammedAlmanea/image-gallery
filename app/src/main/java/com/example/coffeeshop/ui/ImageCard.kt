package com.example.coffeeshop

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.data.domin.Image
import com.example.coffeeshop.ui.imageslist.NetworkImage

@Composable
fun ImageCard(pic1 : Image)
{
    Card(
        elevation = 15.dp,
//        shape = MaterialTheme.shapes.small,
        shape = RoundedCornerShape(16.dp)
       , modifier = Modifier
            .padding(horizontal = 5.dp)
            .padding(vertical = 10.dp)
            .border(
                2.dp,
                Color.Black,
//                MaterialTheme.shapes.small
                RoundedCornerShape(16.dp)
            )
    ) {
        Box(modifier = Modifier.size(300.dp))
        {
            NetworkImage(
                url = pic1.downloadUrl,
                contentDesc =null,
                modifier = Modifier.size(300.dp)
            )
            Text(
                text = pic1.author,
                modifier = Modifier
                    .fillMaxWidth()
//                    .background(Color.Black.copy(alpha = 0.3f))
                    .background(MaterialTheme.colors.secondary.copy(alpha = 0.6f))
                    .align(Alignment.BottomCenter),
                style = MaterialTheme.typography.body1
            )
        }
    }

}
