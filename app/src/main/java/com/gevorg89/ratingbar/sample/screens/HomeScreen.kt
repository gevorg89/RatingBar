package com.gevorg89.ratingbar.sample.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    openCircle: () -> Unit,
    openStars: () -> Unit,
    openSingleImage: () -> Unit,
    openText: () -> Unit
) {
    Column {
        RowItem {
            TemplateItem(text = "Stars") {
                openStars()
            }
            TemplateItem(text = "CircleShape") {
                openCircle()
            }
        }
        RowItem {
            TemplateItem(text = "Image") {
                openSingleImage()
            }
            TemplateItem(text = "Text") {
                openText()
            }
        }
    }
}

@Composable
private fun RowItem(content: @Composable () -> Unit) {
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
private fun TemplateItem(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = text, Modifier.width(100.dp))
    }
}