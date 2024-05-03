package com.example.plantapp.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantapp.data.Plant
import com.example.plantapp.data.PlantsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ContentViewModel(plantsRepository: PlantsRepository) : ViewModel() {

    val contentUiState: StateFlow<ContentUiState> =
        plantsRepository.getAll().map { ContentUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ContentUiState()
            )

    // EXPLAIN WHY THIS IS SET
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for ContentScreen
 */
data class ContentUiState(val itemList: List<Plant> = listOf())