package com.kingsler.riseofj2r.ApiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kingsler.riseofj2r.R

@Composable
fun NewDashboardScreen(
    navController: NavHostController,
    playerName: String = "PlayerOne",
    currentLevel: Int = 5,
    currentScore: Int = 1200,
    onStartRace: () -> Unit = {},
    onViewLeaderboard: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "🏁 Welcome back, $playerName!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("📊 Player Stats", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Level: $currentLevel")
                Text("Score: $currentScore")
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1E))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("🎮 Game Status", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Last Race: Silver City Circuit", color = Color.LightGray)
                Text("Position: 3rd", color = Color.LightGray)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onStartRace,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(Icons.Default.PlayArrow, contentDescription = "Start")
            Spacer(Modifier.width(8.dp))
            Text("Start Race")
        }

        OutlinedButton(
            onClick = onViewLeaderboard,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Icon(Icons.Default.Leaderboard, contentDescription = "Leaderboard")
            Spacer(Modifier.width(8.dp))
            Text("Leaderboard")
        }

        OutlinedButton(
            onClick = onSettingsClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Icon(Icons.Default.Settings, contentDescription = "Settings")
            Spacer(Modifier.width(8.dp))
            Text("Settings")
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.dodge),
            contentDescription = "Game Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    // ❗ Preview doesn't support NavController, so use a dummy one
    NewDashboardScreen(
        navController = rememberNavController(),
        playerName = "PreviewPlayer",
        currentLevel = 4,
        currentScore = 999
    )
}
