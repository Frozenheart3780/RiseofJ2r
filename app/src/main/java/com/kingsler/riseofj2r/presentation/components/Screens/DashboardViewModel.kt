package com.kingsler.riseofj2r.presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel


data class ActivityItem(val id: Int, val description: String, val time: String)

data class DashboardUiState(
    val userName: String = "User",
    val activities: List<ActivityItem> = emptyList(),
    val notificationsCount: Int = 0,
    val tasksCount: Int = 0,
    val messagesCount: Int = 0
)

class DashboardViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        DashboardUiState(
            userName = "Kingsler",
            activities = listOf(
                ActivityItem(1, "Logged in from mobile", "2 hours ago"),
                ActivityItem(2, "Completed task: Design UI mockups", "1 day ago"),
                ActivityItem(3, "Commented on project report", "3 days ago"),
                ActivityItem(4, "Updated profile details", "5 days ago")
            ),
            notificationsCount = 5,
            tasksCount = 8,
            messagesCount = 3
        )
    )
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    // Example function to simulate updating activities or counts
    fun addActivity(activity: ActivityItem) {
        _uiState.update { currentState ->
            currentState.copy(
                activities = listOf(activity) + currentState.activities
            )
        }
    }

    // Example: reset counts or handle logout
    fun resetDashboard() {
        _uiState.value = DashboardUiState()
    }
}

@Composable
fun DashboardScreen(
    navController: NavHostController,
    viewModel: DashboardViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    // Then replace userName, activities, counts with uiState values:
    val userName = uiState.userName
    val activities = uiState.activities
    val notificationsCount = uiState.notificationsCount
    val tasksCount = uiState.tasksCount
    val messagesCount = uiState.messagesCount

    // ...use these variables in your UI like before
}
