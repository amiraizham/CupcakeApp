package com.example.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.ui.theme.CupcakeTheme
import com.example.cupcake.ui.theme.LandingPage

class LandingPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CupcakeTheme {
                // Set up the NavController
                val navController = rememberNavController()

                // Define the NavHost with routes
                NavHost(navController = navController, startDestination = "landingPage") {
                    // Landing page composable
                    composable("landingPage") {
                        LandingPage(navController = navController)  // Pass NavController
                    }

                    // CupcakeApp composable
                    composable("CupcakeApp") {
                        CupcakeApp(
                            navigateToLandingPage = {
                                // Navigate back to the landing page
                                navController.popBackStack("landingPage", inclusive = false)
                            }
                        )
                    }
                }
            }
        }
    }
}
