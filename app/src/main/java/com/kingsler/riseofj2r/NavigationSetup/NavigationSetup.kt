package com.kingsler.riseofj2r.NavigationSetup

sealed class Screen(val route: String) {
    object List : Screen("instruction_list")
    object AddEdit : Screen("add_edit_instruction")
}
