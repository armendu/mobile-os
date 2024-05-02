package com.example.plantapp

import android.content.Context
import com.example.plantapp.data.AppDatabase
import com.example.plantapp.data.OfflinePlantsRepository
import com.example.plantapp.data.PlantsRepository

interface AppContainer {
    val plantsRepository: PlantsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val plantsRepository: PlantsRepository by lazy {
        OfflinePlantsRepository(AppDatabase.getDatabase(context).plantsDao())
    }
}