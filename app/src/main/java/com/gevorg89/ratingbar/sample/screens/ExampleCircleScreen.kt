package com.gevorg89.ratingbar.sample.screens

import RatingBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircleScreen() {
    var valueState by remember { mutableStateOf(4.5f) }
    val width = 32.dp
    RatingBar(
        modifier = Modifier
            .background(Color.Gray)
            .padding(16.dp),
        empty = {
            CircleRating(Color.Cyan, width)
        },
        filled = {
            CircleRating(Color.Red, width)
        },
        stepSize = 0.5f,
        steps = 10,
        value = valueState
    ) { rating ->
        valueState = rating
    }
}

@Composable
private fun CircleRating(color: Color, width: Dp) {
    Column(
        Modifier
            .size(width)
            .clip(CircleShape)
            .background(color)
    ) {}
}