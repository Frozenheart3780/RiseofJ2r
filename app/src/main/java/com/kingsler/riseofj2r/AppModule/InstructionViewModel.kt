//package com.kingsler.riseofj2r.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.kingsler.riseofj2r.data.local.Instruction1
//import dagger.hilt.android.lifecycle.
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//open class InstructionViewModel @Inject constructor() : ViewModel() {
//
//    // Backing property
//    private val _instructions = MutableStateFlow<List<Instruction1>>(emptyList())
//
//    // Exposed immutable state
//    open val instructions: StateFlow<List<Instruction1>> = _instructions
//
//    open fun loadAllInstructions() {
//        viewModelScope.launch {
//            _instructions.value = repository.getAll()
//        }
//    }
//
//    open fun addInstruction(instruction: Instruction1) {
//        viewModelScope.launch {
//            repository.insertInstruction(instruction)
//            loadAllInstructions()
//        }
//    }
//
//    open fun deleteInstruction(instruction: Instruction1) {
//        viewModelScope.launch {
//            repository.deleteInstruction(instruction)
//            loadAllInstructions()
//        }
//    }
//}
