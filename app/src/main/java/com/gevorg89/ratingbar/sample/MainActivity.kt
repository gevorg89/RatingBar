package com.gevorg89.ratingbar.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gevorg89.ratingbar.sample.Destinations.Circle
import com.gevorg89.ratingbar.sample.Destinations.Home
import com.gevorg89.ratingbar.sample.Destinations.SingleImage
import com.gevorg89.ratingbar.sample.Destinations.Stars
import com.gevorg89.ratingbar.sample.Destinations.Text
import com.gevorg89.ratingbar.sample.screens.*
import com.gevorg89.ratingbar.ui.theme.RatingBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val actions = remember(navController) { Actions(navController) }
            RatingBarTheme {
                NavHost(navController = navController, startDestination = Home) {
                    composable(Home) {
                        HomeScreen(
                            actions.openCircle,
                            actions.openStars,
                            actions.openSingleImage,
                            actions.openText
                        )
                    }
                    composable(Stars) {
                        StarsScreen()
                    }
                    composable(Circle) {
                        CircleScreen()
                    }
                    composable(SingleImage) {
                        SingleImageScreen()
                    }
                    composable(Text) {
                        TextScreen()
                    }
                }
            }
        }
    }
}


