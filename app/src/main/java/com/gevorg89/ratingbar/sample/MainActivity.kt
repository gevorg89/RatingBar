package com.gevorg89.ratingbar.sample

import Slider
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gevorg89.ratingbar.ui.theme.RatingBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RatingBarTheme {
                Surface(color = MaterialTheme.colors.background) {
                    //SliderScreen()
                    Column {
                        RowItem {
                            TemplateItem(text = "Stars") {

                            }
                            TemplateItem(text = "CircleShape") {

                            }
                        }
                        RowItem {
                            TemplateItem(text = "Image") {

                            }
                            TemplateItem(text = "Text") {

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RowItem(content: @Composable () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        content()
    }
}

@Composable
fun TemplateItem(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = text, Modifier.width(100.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SliderScreen() {
    var valueState by remember { mutableStateOf(4.5f) }
    val width = 32.dp
    Slider(
        modifier = Modifier
            .background(Color.Gray)
            .padding(16.dp),
        out = {
            //CircleRating(Color.Cyan, width)
            //ImageRating(R.drawable.ic_baseline_star_outline_24, width)
            //AndroidRating(Color.LightGray)
            TextRating(color = Color.Black, text = "Hello Android!!!")
        },
        fill = {
            //CircleRating(Color.Red, width)
            //ImageRating(R.drawable.ic_baseline_star_24, width)
            //AndroidRating(Color.Green)
            TextRating(color = Color.Green, text = "Hello Android!!!")
        },
        stepSize = 0.01f,
        steps = 1,
        value = valueState,
        isIndicator = false
    ) { rating ->
        valueState = rating
    }
    Column(Modifier.padding(top = 100.dp)) {
        Text(text = valueState.toString())
        Button(onClick = {
            valueState = 4f
        }) {
            Text(text = "CHANGE")
        }
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

@Composable
private fun ImageRating(@DrawableRes drawable: Int, width: Dp = 24.dp) {
    Image(
        painterResource(drawable),
        contentDescription = "",
        modifier = Modifier.size(width)
    )
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

@Composable
private fun TextRating(color: Color, text: String) {
    Text(
        text = text,
        color = color
    )
}


