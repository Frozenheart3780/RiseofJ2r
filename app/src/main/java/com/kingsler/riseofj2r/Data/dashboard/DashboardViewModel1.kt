package com.kingsler.riseofj2r.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel1 : ViewModel() {

    // Backing state values for UI
    private val _playerName = MutableStateFlow("Loading...")
    val playerName: StateFlow<String> = _playerName

    private val _currentLevel = MutableStateFlow(0)
    val currentLevel: StateFlow<Int> = _currentLevel

    private val _currentScore = MutableStateFlow(0)
    val currentScore: StateFlow<Int> = _currentScore

    // Called to load dynamic player data
    fun loadPlayerData() {
        viewModelScope.launch {
            // Replace this block with real data fetching (e.g., Firebase or Room)
            _playerName.value = "Johnny Drift"
            _currentLevel.value = 8
            _currentScore.value = 3450
        }
    }
}
