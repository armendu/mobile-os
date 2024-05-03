package com.example.plantapp

import android.app.Application
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.plantapp.items.ContentViewModel
//import com.example.plantapp.items.PlantViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory

object ViewModelProvider {
    val Factory = viewModelFactory {
//        initializer {
//            PlantViewModel(
//                getApplication().container.plantsRepository
//            )
//        }

        initializer {
            ContentViewModel(
                getApplication().container.plantsRepository
            )
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [PlantApp].
 */
fun CreationExtras.getApplication(): PlantApp =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as PlantApp)