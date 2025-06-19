package com.kingsler.riseofj2r

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.kingsler.riseofj2r.navigation.AppNavGraph
import com.kingsler.riseofj2r.ui.theme.RISEOfJ2RTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)
        setContent {
            RISEOfJ2RTheme {
                val navController = rememberNavController()
                AppNavGraph(navController
                )


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RISEOfJ2RTheme {
    }
}
