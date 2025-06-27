//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.kingsler.riseofj2r.Crudconfig.Instruction
//import com.kingsler.riseofj2r.data.local.Instruction1
//import com.kingsler.riseofj2r.viewmodel.InstructionViewModel
//
//@Composable
//fun InstructionItem(
//    instr: Instruction,
//    viewModel: InstructionViewModel
//) {
//    var showConfirm by remember { mutableStateOf(false) }
//
//    if (showConfirm) {
//        AlertDialog(
//            onDismissRequest = { showConfirm = false },
//            title = { Text("Delete Instruction") },
//            text = { Text("Are you sure you want to delete \"${instr.title}\"?") },
//            confirmButton = {
//                TextButton(onClick = {
//                    viewModel.deleteInstruction(instr.toInstruction1())
////
//                    showConfirm = false
//                }) {
//                    Text("Delete", color = MaterialTheme.colorScheme.error)
//                }
//            },
//            dismissButton = {
//                TextButton(onClick = { showConfirm = false }) {
//                    Text("Cancel")
//                }
//            }
//        )
//    }
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(12.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Column(modifier = Modifier.weight(1f)) {
//            Text(text = instr.title, style = MaterialTheme.typography.titleMedium)
//            Text(text = instr.category, style = MaterialTheme.typography.labelSmall)
//            Text(text = instr.content, style = MaterialTheme.typography.bodyMedium, maxLines = 2)
//        }
//
//        IconButton(onClick = { showConfirm = true }) {
//            Icon(
//                imageVector = Icons.Default.Delete,
//                contentDescription = "Delete Instruction",
//                tint = MaterialTheme.colorScheme.error
//            )
//        }
//    }
//}
//
//private fun Instruction.toInstruction1(): Instruction1 {
//    TODO("Not yet implemented")
//}
