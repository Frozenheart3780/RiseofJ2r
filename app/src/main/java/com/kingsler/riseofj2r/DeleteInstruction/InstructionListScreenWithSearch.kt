package com.kingsler.riseofj2r.presentation.instructions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kingsler.riseofj2r.Crudconfig.Instruction
import com.kingsler.riseofj2r.Crudconfig.InstructionViewModel
import kotlinx.coroutines.launch

@Composable
fun InstructionListScreen(viewModel: InstructionViewModel = viewModel()) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var query by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf(emptyList<Instruction>()) }

    LaunchedEffect(true) {
        viewModel.getAllInstructions { instructions = it }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search Instructions") },
                modifier = Modifier.fillMaxWidth()
            )

            val filtered = instructions.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.category.contains(query, ignoreCase = true)
            }

            LazyColumn {
                items(filtered) { instr ->
                    InstructionItem(
                        instr = instr,
                        viewModel = viewModel,
                        onDeleted = {
                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    message = "\"${instr.title}\" deleted",
                                    actionLabel = "Undo"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.undoDelete()
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

private fun InstructionViewModel.undoDelete() {


}

@Composable
fun InstructionItem(
    instr: Instruction,
    viewModel: InstructionViewModel,
    onDeleted: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Delete Instruction") },
            text = { Text("Are you sure you want to delete \"${instr.title}\"?") },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.deleteInstruction(instr)
                    onDeleted()
                    showDialog = false
                }) {
                    Text("Delete", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = instr.title, style = MaterialTheme.typography.titleMedium)
            Text(text = instr.category, style = MaterialTheme.typography.labelSmall)
            Text(text = instr.content, style = MaterialTheme.typography.bodyMedium, maxLines = 2)
        }

        IconButton(onClick = { showDialog = true }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Instruction",
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}
