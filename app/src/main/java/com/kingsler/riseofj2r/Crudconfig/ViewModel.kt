package com.kingsler.riseofj2r.Crudconfig

// InstructionViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class InstructionViewModel(private val repo: InstructionRepository) : ViewModel() {

    fun addInstruction(instruction: Instruction) = viewModelScope.launch {
        repo.create(instruction)
    }

    fun getAllInstructions(onResult: (List<Instruction>) -> Unit) = viewModelScope.launch {
        onResult(repo.readAll())
    }

    fun updateInstruction(instruction: Instruction) = viewModelScope.launch {
        repo.update(instruction)
    }

    fun deleteInstruction(instruction: Instruction) = viewModelScope.launch {
        repo.delete(instruction)
    }

}
