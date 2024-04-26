package com.example.plantapp.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val plantsRepository: PlantsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflinePlantsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {

    override val plantsRepository: PlantsRepository by lazy {
        OfflinePlantsRepository(AppDatabase.getDatabase(context).plantDao())
    }
}
