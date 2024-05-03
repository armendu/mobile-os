package com.example.plantapp.items

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.plantapp.data.Plant
import com.example.plantapp.data.PlantsRepository

//class PlantViewModel(private val plantsRepository: PlantsRepository) : ViewModel() {
//
//    // Holds current state
//    private var plantUiState by mutableStateOf(PlantUiState())
//
//    // Update ui state and validate it
//    fun updateUiState(plantDetails: PlantDetails) {
//        plantUiState = PlantUiState(plantDetails, isEntryValid = validateInput(plantDetails))
//    }
//
//    suspend fun savePlant() {
//        if (validateInput()) {
//            plantsRepository.insert(plantUiState.plantDetails.toPlant())
//        }
//    }
//
//    private fun validateInput(uiState: PlantDetails = plantUiState.plantDetails): Boolean {
//        return with(uiState) {
//            name.isNotBlank()
//        }
//    }
//}
//
//data class PlantUiState(
//    val plantDetails: PlantDetails = PlantDetails(),
//    val isEntryValid: Boolean = false
//)
//
//data class PlantDetails(
//    val id: Int = 0,
//    val name: String = "",
//    val description: String? = null
//)
//
//fun PlantDetails.toPlant(): Plant = Plant(
//    uid = id,
//    name = name,
//    description = description
//)