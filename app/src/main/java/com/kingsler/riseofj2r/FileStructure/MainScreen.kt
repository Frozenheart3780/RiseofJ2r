package com.kingsler.riseofj2r.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainMenuScreen(navController: NavController) {
    val menuItems = listOf(
        "Start Race" to "start_race",
        "Profile Screen" to "profile",
        "Game Play" to "game_play",
        "Avatar - Select Image" to "avatar",
        "Firebase - Phone Number Submit" to "firebase_submit",
        "Mpesa" to "mpesa",
        "Game" to "game",
        "Instruction" to "instruction"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Black)
    ) {
        Text(
            text = "Main Menu",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))

        menuItems.forEach { (label, route) ->
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                onClick = { navController.navigate(route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ) {
                Text(text = label)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainMenuScreen() {
    MaterialTheme {
        MainMenuScreen(navController = rememberNavController())
    }
}
