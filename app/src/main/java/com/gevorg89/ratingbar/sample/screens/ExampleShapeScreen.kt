package com.gevorg89.ratingbar.sample.screens

import RatingBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun ShapeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        CircleShapeRatingBar()
        SquareShapeRatingBar()
        TriangleShapeRatingBar()
    }
}

@ExperimentalComposeUiApi
@Composable
fun ShapeRatingBar(empty: @Composable () -> Unit, filled: @Composable () -> Unit) {
    var valueState by remember { mutableStateOf(4.5f) }
    RatingBar(
        modifier = Modifier
            .padding(16.dp),
        empty = empty,
        filled = filled,
        stepSize = 0.5f,
        steps = 10,
        value = valueState
    ) { rating ->
        valueState = rating
    }
}

@ExperimentalComposeUiApi
@Composable
fun CircleShapeRatingBar() {
    val width = 32.dp
    ShapeRatingBar(
        empty = { CircleRating(Color.Cyan, width) },
        filled = { CircleRating(Color.Red, width) })
}

@ExperimentalComposeUiApi
@Composable
fun SquareShapeRatingBar() {
    val width = 32.dp
    ShapeRatingBar(
        empty = { SquareRating(Color.Cyan, width) },
        filled = { SquareRating(Color.Red, width) })
}

@ExperimentalComposeUiApi
@Composable
fun TriangleShapeRatingBar() {
    val width = 32.dp
    ShapeRatingBar(
        empty = { TriangleRating(Color.Cyan, width) },
        filled = { TriangleRating(Color.Red, width) })
}

@Composable
private fun CircleRating(color: Color, width: Dp) {
    ShapeRating(color = color, width = width, shape = CircleShape)
}

@Composable
private fun SquareRating(color: Color, width: Dp) {
    ShapeRating(color = color, width = width, shape = RoundedCornerShape(0.dp))
}

@Composable
private fun TriangleRating(color: Color, width: Dp) {
    ShapeRating(color = color, width = width, shape = TriangleShape)
}

private val TriangleShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height)
    lineTo(0f, size.height)
}

@Composable
private fun ShapeRating(color: Color, width: Dp, shape: Shape) {
    Column(
        Modifier
            .size(width)
            .clip(shape)
            .background(color)
    ) {}
}