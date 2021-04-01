package com.gevorg89.ratingbar.sample.screens

import RatingBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextScreen() {
    var valueState by remember { mutableStateOf(0.75f) }
    RatingBar(
        modifier = Modifier
            .background(Color.Gray)
            .padding(16.dp),
        empty = {
            TextRating(color = Color.Black)
        },
        filled = {
            TextRating(color = Color.Green)
        },
        stepSize = 0.01f,
        steps = 1,
        value = valueState
    ) { rating ->
        valueState = rating
    }
}


@Composable
private fun TextRating(color: Color) {
    Text(
        text = "Hello Android!!!",
        color = color,
        modifier = Modifier.fillMaxSize(),
        fontSize = 48.sp,
        textAlign = TextAlign.Center
    )
}