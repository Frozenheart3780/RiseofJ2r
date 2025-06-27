//package com.kingsler.riseofj2r.ApiScreens
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import androidx.navigation.NavHostController
//import com.kingsler.riseofj2r.presentation.components.DashboardScreen
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//// ✅ Data class to hold state
//data class DashboardState(
//    val playerName: String = "PlayerOne",
//    val currentLevel: Int = 1,
//    val currentScore: Int = 0,
//    val lastRace: String = "N/A",
//    val position: String = "N/A",
//    val isLoading: Boolean = false
//)
//
//// ✅ ViewModel
//class DashboardViewModel : ViewModel() {
//
//    private val _dashboardState = MutableStateFlow(DashboardState())
//    val dashboardState: StateFlow<DashboardState> = _dashboardState
//
//    init {
//        loadDashboardData()
//    }
//
//    fun loadDashboardData() {
//        viewModelScope.launch {
//            _dashboardState.value = _dashboardState.value.copy(isLoading = true)
//
//            delay(1500) // Simulate network/db
//
//            _dashboardState.value = _dashboardState.value.copy(
//                playerName = "J-Rider",
//                currentLevel = 7,
//                currentScore = 2580,
//                lastRace = "Neon Drift Valley",
//                position = "1st",
//                isLoading = false
//            )
//        }
//    }
//
//    fun refresh() = loadDashboardData()
//}
//
//// ✅ Composable screen function for NavGraph
//@Composable
//fun DashboardScreenWrapper(
//    navController: NavHostController,
//    viewModel: DashboardViewModel = hiltViewModel()
//) {
//    val state by viewModel.dashboardState.collectAsState()
//
//    LaunchedEffect(Unit) {
//        viewModel.loadDashboardData()
//    }
//
//    if (state.isLoading) {
//        androidx.compose.material3.CircularProgressIndicator()
//    } else {
//        DashboardScreen(
//            navController = navController,
//            playerName = state.playerName,
//            currentLevel = state.currentLevel,
//            currentScore = state.currentScore,
//            onStartRace = {
//                // TODO: navController.navigate("race")
//            },
//            onViewLeaderboard = {
//                // TODO: navController.navigate("leaderboard")
//            },
//            onSettingsClick = {
//                // TODO: navController.navigate("settings")
//            }
//        )
//    }
//}
