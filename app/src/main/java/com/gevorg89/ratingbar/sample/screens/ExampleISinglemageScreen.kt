package com.gevorg89.ratingbar.sample.screens

import RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gevorg89.ratingbar.sample.R

@Composable
fun SingleImageScreen() {
    var valueState by remember { mutableStateOf(0.5f) }
    RatingBar(
        modifier = Modifier
            .background(Color.Gray)
            .padding(16.dp),
        out = {
            AndroidRating(Color.LightGray)
        },
        fill = {
            AndroidRating(Color.Green)
        },
        stepSize = 0.01f,
        steps = 1,
        value = valueState,
        isIndicator = false
    ) { rating ->
        valueState = rating
    }
}

@Composable
private fun AndroidRating(tint: Color) {
    Image(
        painterResource(R.drawable.ic_baseline_android_24),
        contentDescription = "",
        modifier = Modifier.fillMaxSize(),
        colorFilter = ColorFilter.tint(color = tint)
    )
}