package com.kingsler.riseofj2r.NavigationSetup.Add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kingsler.riseofj2r.Crudconfig.Instruction
import com.kingsler.riseofj2r.Crudconfig.InstructionViewModel

@Composable
fun AddEditInstructionScreen(viewModel: InstructionViewModel, nav: NavController, id: Int) {
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    LaunchedEffect(id) {
        if (id != -1) {
            viewModel.getAllInstructions { list ->
                val item = list.find { it.id == id }
                item?.let {
                    title = it.title
                    category = it.category
                    content = it.content
                }
            }
        }
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        OutlinedTextField(value = category, onValueChange = { category = it }, label = { Text("Category") })
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") },
            modifier = Modifier.height(150.dp)
        )

        Button(onClick = {
            val instruction = Instruction(id = if (id == -1) 0 else id, title, category, content)
            if (id == -1) viewModel.addInstruction(instruction)
            else viewModel.updateInstruction(instruction)
            nav.popBackStack()
        }) {
            Text(if (id == -1) "Add Instruction" else "Update Instruction")
        }
    }
}
