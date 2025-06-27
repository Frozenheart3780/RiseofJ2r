package com.kingsler.riseofj2r.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kingsler.riseofj2r.ApiScreens.NewDashboardScreen
import com.kingsler.riseofj2r.presentation.components.ForgotPassword
import com.kingsler.riseofj2r.presentation.components.LoginScreen
import com.kingsler.riseofj2r.presentation.components.Screens.MainHomeScreen
import com.kingsler.riseofj2r.presentation.components.SignUpScreen
import com.kingsler.riseofj2r.screens.MainMenuScreen
import com.kingsler.riseofj2r.screens.MpesaPaymentScreen
import com.kingsler.riseofj2r.screens.ProfileScreen
import com.kingsler.riseofj2r.screens.StartRaceScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "signup"
    ) {
        composable("signup") {
            SignUpScreen(navController) // → Navigate to "login"
        }
        composable("login") {
            LoginScreen(navController) // → Navigate to "forgot_password" or "profile"
        }
        composable("forgot_password") {
            ForgotPassword(navController) // → Navigate back to "login"
        }
        composable("profile") {
            ProfileScreen(navController) // → Navigate to "start_race"
        }
        composable("start_race") {
            StartRaceScreen(navController) // → Navigate to "mainscreen"
        }
        composable("mpesa") {
            MpesaPaymentScreen(navController)
        }

        composable("mainscreen") {
            MainMenuScreen(navController) // → Navigate to "dashboard"
        }
        composable("dashboard") {
            NewDashboardScreen(navController) // → Navigate to "mainHome"
        }
        composable("mainHome") {
            MainHomeScreen(navController) // ✅ Final screen (home)
        }
    }
}
