package com.kingsler.riseofj2r.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.elevatedCardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

data class TodoItem(
    val id: Int,
    val title: String,
    val description: String,
    val dueDate: LocalDate,
    val priority: String,
    val isCompleted: Boolean
)

@Composable
fun TodoItemCard(
    todoItem: TodoItem,
    onToggleComplete: (Int) -> Unit,
    onDelete: (Int) -> Unit,
    onEdit: (Int) -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (todoItem.isCompleted) Color(0xFFD0F0C0) else Color(0xFFF0F0F0),
        label = "cardBackgroundColor"
    )

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = elevatedCardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = todoItem.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = { onToggleComplete(todoItem.id) }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Complete",
                        tint = if (todoItem.isCompleted) Color.Green else Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = todoItem.description,
                fontSize = 16.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Due: ${todoItem.dueDate}",
                    color = Color.Red,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Priority: ${todoItem.priority}",
                    color = when (todoItem.priority) {
                        "High" -> Color.Red
                        "Medium" -> Color(0xFFFFA500) // Orange
                        else -> Color.Green
                    },
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { onEdit(todoItem.id) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.Blue)
                }
                IconButton(onClick = { onDelete(todoItem.id) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewTodoItemCard() {
    TodoItemCard(
        todoItem = TodoItem(
            id = 1,
            title = "Fix ViewModel Error",
            description = "Refactor the ViewModel and clean up repository imports.",
            dueDate = LocalDate.now().plusDays(2),
            priority = "High",
            isCompleted = false
        ),
        onToggleComplete = {},
        onDelete = {},
        onEdit = {}
    )
}










