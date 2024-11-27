package com.example.cupcake.ui.theme

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LandingPage(navController: NavController) {
    val context = LocalContext.current
    CupcakeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                contentAlignment = Alignment.Center, // Center everything inside the Box
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(horizontal = 16.dp) // Added horizontal padding for better layout
                ) {
                    // Title - "LANDING SCREEN"
                    Text(
                        text = "LANDING SCREEN",
                        fontSize = 30.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.align(Alignment.CenterHorizontally) // Center the text horizontally
                    )

                    Spacer(modifier = Modifier.height(50.dp)) // Adds space between title and buttons

                    // Buttons
                    Button(
                        onClick = { openAppByPackageName(context, "com.example.a195662_happybirthday", "MainActivity") },
                        colors = MaterialTheme.colorScheme.run {
                            androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = tertiary,
                                contentColor = onTertiary
                            )
                        },
                        modifier = Modifier.fillMaxWidth() // Button will take full width
                    ) {
                        Text("New Year Wish Card")
                    }

                    Button(
                        onClick = { openAppByPackageName(context, "com.example.woof", "MainActivity") },
                        colors = MaterialTheme.colorScheme.run {
                            androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = tertiary,
                                contentColor = onTertiary
                            )
                        },
                        modifier = Modifier.fillMaxWidth() // Button will take full width
                    ) {
                        Text("Woof App")
                    }

                    Button(
                        onClick = { navController.navigate("CupcakeApp") },
                        modifier = Modifier
                            .fillMaxWidth() // Button will take full width
                            .padding(bottom = 16.dp), // Adds padding to the bottom of the button
                        colors = MaterialTheme.colorScheme.run {
                            androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = tertiary,
                                contentColor = onTertiary
                            )
                        }
                    ) {
                        Text("Cupcake App")
                    }
                }
            }
        }
    }
}

fun openAppByPackageName(context: android.content.Context, packageName: String, activityName: String) {
    try {
        val intent = Intent()
        intent.setClassName(packageName, "$packageName.$activityName")
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "App or Activity not found", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun LandingPagePreview() {
    val navController = rememberNavController()
    LandingPage(navController = navController)
}
