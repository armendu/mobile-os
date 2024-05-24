package com.example.plantapp.screens.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantapp.data.PlantsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ContentViewModel(plantsRepository: PlantsRepository) : ViewModel() {
    val contentUiState : StateFlow<ContentUiState> =
        plantsRepository.getAll().map {
            ContentUiState(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ContentUiState()
        )
}

