package com.kingsler.riseofj2r.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingsler.riseofj2r.data.local.Instruction1
import com.kingsler.riseofj2r.data.local.InstructionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InstructionViewModel @Inject constructor(
    private val repository: InstructionRepository
) : ViewModel() {

    private val _instructions = MutableStateFlow<List<Instruction1>>(emptyList())
    val instructions: StateFlow<List<Instruction1>> = _instructions

    fun loadAllInstructions() {
        viewModelScope.launch {
            _instructions.value = repository.getAll() as List<Instruction1>
        }
    }

    fun addInstruction(instruction: Instruction1) {
        viewModelScope.launch {
            repository.insert(instruction)
            loadAllInstructions()
        }
    }

    fun deleteInstruction(instruction: Instruction1) {
        viewModelScope.launch {
            repository.delete(instruction)
            loadAllInstructions()
        }
    }
}
