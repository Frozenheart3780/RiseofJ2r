package com.kingsler.riseofj2r.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingsler.riseofj2r.data.model.ApiResponse
import com.kingsler.riseofj2r.data.model.Instruction
import com.kingsler.riseofj2r.data.remote.ApiRepository
import com.kingsler.riseofj2r.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiViewModel(
    private val repository: ApiRepository
) : ViewModel() {

    private val _apiState = MutableStateFlow<Resource<ApiResponse>>(Resource.Loading())
    val apiState: StateFlow<Resource<ApiResponse>> = _apiState

    fun fetchApiData() {
        _apiState.value = Resource.Loading()

        viewModelScope.launch {
            try {
                val response = repository.getData()

            } catch (e: Exception) {
                _apiState.value = Resource.Error(e.localizedMessage ?: "Unknown error")
            }
        }
        fun CoroutineScope.getAllInstructions(function: () -> Unit) {
            TODO("Not yet implemented")
        }

        fun deleteInstruction(instruction: Instruction) {
            viewModelScope.launch {
                repository.deleteInstruction(instruction)
                getAllInstructions { } // Refresh list
            }
        }


    }
}
