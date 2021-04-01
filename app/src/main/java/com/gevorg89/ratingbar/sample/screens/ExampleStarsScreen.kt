package com.gevorg89.ratingbar.sample.screens

import RatingBar
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gevorg89.ratingbar.sample.R

@Composable
fun StarsScreen() {
    var valueState by remember { mutableStateOf(4.5f) }
    val width = 32.dp
    Column {
        RatingBar(
            modifier = Modifier
                .background(Color.Gray)
                .padding(16.dp),
            out = {
                StarRating(R.drawable.ic_baseline_star_outline_24, width)
            },
            fill = {
                StarRating(R.drawable.ic_baseline_star_24, width)
            },
            stepSize = 0.5f,
            steps = 5,
            value = valueState,
            isIndicator = false
        ) { rating ->
            valueState = rating
        }
        Column{
            Text(text = valueState.toString())
            Button(onClick = {
                valueState = 1.5f
            }) {
                Text(text = "Change value to 1.5")
            }
        }
    }

}

@Composable
private fun StarRating(@DrawableRes drawable: Int, width: Dp = 24.dp) {
    Image(
        painterResource(drawable),
        contentDescription = "",
        modifier = Modifier.size(width)
    )
}