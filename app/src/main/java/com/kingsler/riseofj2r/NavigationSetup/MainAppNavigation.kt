package com.kingsler.riseofj2r.NavigationSetup

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kingsler.riseofj2r.Crudconfig.InstructionViewModel

@Composable
fun RiseOfJApp(viewModel: InstructionViewModel) {
    val navController = rememberNavController()

    val instructionListScreen = InstructionListScreen(viewModel, navController)
    NavHost(navController = navController, startDestination = Screen.List.route) {
        composable(Screen.List.route) {
            instructionListScreen
        }
        composable(Screen.AddEdit.route + "?id={id}",
            arguments = listOf(navArgument("id") {
                defaultValue = -1
            })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: -1
            AddEditInstructionScreen(viewModel, navController, id)
        }
    }
}

@Composable
fun AddEditInstructionScreen(x0: InstructionViewModel, x1: NavHostController, x2: Int) {
    TODO("Not yet implemented")
}

@Composable
fun InstructionListScreen(x0: InstructionViewModel, x1: NavHostController) {
    TODO("Not yet implemented")
}
