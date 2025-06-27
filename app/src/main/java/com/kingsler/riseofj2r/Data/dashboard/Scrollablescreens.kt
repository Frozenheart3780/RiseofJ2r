package com.kingsler.riseofj2r.Data.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DashboardContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        NotificationsSection()
        Spacer(Modifier.height(16.dp))
        TasksSection()
        Spacer(Modifier.height(16.dp))

        MessagesSection()
        Button( onClick = {  navController.navigate("dashboard")}) {
            Text(text = "Go to Dashboard")

        }
    }
}

@Composable
fun NotificationsSection() {
    SectionCard(title = "🔔 Notifications") {
        Text("- New event: Neon Drift starts today!")
        Text("- Your friend Alex just beat your high score.")
    }
}

@Composable
fun TasksSection() {
    SectionCard(title = "📋 Tasks") {
        Text("- Complete the Silver City Circuit")
        Text("- Upgrade your Nitro Boost")
        Text("- Customize your racer avatar")
    }
}

@Composable
fun MessagesSection() {
    SectionCard(title = "✉️ Messages") {
        Text("• Team Blaze: \"Ready to race tonight?\"")
        Text("• DevBot: \"Update 1.2.0 is now live.\"")
    }
}

@Composable
fun SectionCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA5D5CA)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardContentPreview() {
    MaterialTheme {
        DashboardContent(navController = rememberNavController())
    }
}
