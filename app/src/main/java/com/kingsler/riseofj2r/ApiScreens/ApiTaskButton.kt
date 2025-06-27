package com.kingsler.riseofj2r.ApiScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingsler.riseofj2r.R

@Composable
fun ApiTaskButton(
    modifier: Modifier = Modifier,
    text: String = "Submit",
    isLoading: Boolean = false,
    onClick: () -> Unit,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    iconResId: Int? = null
) {
    Button(
        onClick = { if (!isLoading) onClick() },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = !isLoading,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = contentColor,
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 8.dp),
                strokeWidth = 2.dp
            )
        } else {
            iconResId?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = "icon",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 8.dp),
                    tint = contentColor
                )
            }
        }

        Text(
            text = if (isLoading) "Loading..." else text,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ApiTaskButtonPreview() {
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ApiTaskButton(
            text = "Fetch Data",
            isLoading = isLoading,
            iconResId = R.drawable.ic_launcher_foreground, // Replace with a real icon if available
            onClick = {
                isLoading = true
                // Simulate an API call delay
                // In real app, handle in ViewModel with coroutine
            }
        )
    }
}

