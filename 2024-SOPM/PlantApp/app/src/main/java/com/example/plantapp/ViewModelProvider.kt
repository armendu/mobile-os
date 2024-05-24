package com.example.plantapp

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.plantapp.screens.content.ContentViewModel

object ViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ContentViewModel(
                getApplicationContext().container.plantsRepository
            )
        }
    }
}

fun CreationExtras.getApplicationContext(): PlantApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PlantApp)