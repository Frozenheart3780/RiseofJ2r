package com.kingsler.riseofj2r.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InstructionScreen() {
    Surface(modifier = Modifier.padding(16.dp)) {
        Text("📜 Game Instructions Go Here", style = MaterialTheme.typography.bodyLarge)
    }
}