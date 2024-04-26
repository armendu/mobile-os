package com.example.plantapp

import android.app.Application
import com.example.plantapp.data.AppContainer
import com.example.plantapp.data.AppDataContainer

class PlantApp : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}