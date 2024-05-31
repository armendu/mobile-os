package com.example.plantapp.screens.content

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantapp.data.PlantsRepository
import com.example.plantapp.services.StorageService
import com.example.plantapp.services.TrefleService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContentViewModel(plantsRepository: PlantsRepository, storageService: StorageService, trefleService: TrefleService) : ViewModel() {
    val contentUiState : StateFlow<ContentUiState> =
        plantsRepository.getAll().map {
            ContentUiState(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ContentUiState()
        )

    val plantsFromStorageService = storageService.getAll()

    fun getPlantById() {
        launchCatching {
//            val editedTask = task.value
//            if (editedTask.id.isBlank()) {
//                storageService.save(editedTask)
//            } else {
//                storageService.update(editedTask)
//            }
        }
    }

    fun logApiData() {
        launchCatching {
            val result = TrefleService.create().getPlants()
            Log.d("ContentViewModel", "data: ${result.data}")
            Log.d("ContentViewModel", "links: ${result.links}")
            Log.d("ContentViewModel", "meta: ${result.meta}")
        }
    }

    private fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                Log.d("ContentViewModel", "An error occurred: ${throwable.message}")
            },
            block = block
        )
}

