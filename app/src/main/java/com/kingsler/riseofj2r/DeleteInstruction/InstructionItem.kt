package com.kingsler.riseofj2r.DeleteInstruction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kingsler.riseofj2r.Crudconfig.Instruction
import com.kingsler.riseofj2r.Crudconfig.InstructionViewModel

@Composable
fun InstructionItem(instr: Instruction, viewModel: InstructionViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = instr.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = instr.category,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = instr.content,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2
            )
        }
        IconButton(onClick = {
            viewModel.deleteInstruction(instr)
        }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Instruction",
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}
