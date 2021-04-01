package com.gevorg89.ratingbar.sample

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.gevorg89.ratingbar.sample.Destinations.Shape
import com.gevorg89.ratingbar.sample.Destinations.SingleImage
import com.gevorg89.ratingbar.sample.Destinations.Stars
import com.gevorg89.ratingbar.sample.Destinations.Text

object Destinations {
    const val Home = "home"
    const val Shape = "circle"
    const val Stars = "Stars"
    const val SingleImage = "singleImage"
    const val Text = "text"
}

class Actions(navController: NavHostController) {
    val openShape: () -> Unit = {
        navController.navigate(Shape)
    }
    val openStars: () -> Unit = {
        navController.navigate(Stars)
    }
    val openSingleImage: () -> Unit = {
        navController.navigate(SingleImage)
    }
    val openText: () -> Unit = {
        navController.navigate(Text)
    }
}