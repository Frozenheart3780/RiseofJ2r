package com.kingsler.riseofj2r.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kingsler.riseofj2r.ApiScreens.ApiDashboard
import com.kingsler.riseofj2r.presentation.components.DashboardScreen
import com.kingsler.riseofj2r.presentation.components.ForgotPassword
import com.kingsler.riseofj2r.presentation.components.LoginScreen
import com.kingsler.riseofj2r.presentation.components.SignUpScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "signup"
    ) {
        composable("signup") {
            SignUpScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("dashboard") {
            DashboardScreen(navController)
        }
        composable("forgot_password") {
            ForgotPassword(navController)
        }
        composable("api_dashboard") {
            ApiDashboard(navController)
        }
        // Future: Add composable("add_todo") { AddTodoScreen(navController) }
    }
}
