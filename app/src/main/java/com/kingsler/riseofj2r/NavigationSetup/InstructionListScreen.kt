//package com.kingsler.riseofj2r.NavigationSetup
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.Card
//import androidx.compose.material.FloatingActionButton
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.kingsler.riseofj2r.Crudconfig.Instruction
//import com.kingsler.riseofj2r.Crudconfig.InstructionViewModel
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun InstructionListScreen(viewModel: InstructionViewModel, nav: NavController) {
//    var instructions by remember { mutableStateOf(emptyList<Instruction>()) }
//
//    LaunchedEffect(Unit) {
//        viewModel.getAllInstructions { instructions = it }
//    }
//
//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                nav.navigate(Screen.AddEdit.route)
//            }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
//    ) {
//        LazyColumn(modifier = Modifier.padding(16.dp)) {
//            items(instructions) { instr ->
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 4.dp)
//                        .clickable {
//                            nav.navigate("${Screen.AddEdit.route}?id=${instr.id}")
//                        }
//                ) {
//                    Column(modifier = Modifier.padding(16.dp)) {
//                        Text(instr.title, style = MaterialTheme.typography.h6)
//                        Text(instr.category, style = MaterialTheme.typography.caption)
//                        Text(instr.content, maxLines = 2)
//                    }
//                }
//            }
//        }
//    }
//}
