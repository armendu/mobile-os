package com.example.plantapp.data

import kotlinx.coroutines.flow.Flow

interface PlantsRepository {
    fun get(uid: Int): Flow<Plant?>
    fun getAll(): Flow<List<Plant>>
    suspend fun insert(plant: Plant)
}

class OfflinePlantsRepository(private val plantsDao: PlantsDao) : PlantsRepository {
    override fun get(uid: Int): Flow<Plant?> {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flow<List<Plant>> = plantsDao.getAll()

    override suspend fun insert(plant: Plant) = plantsDao.insert(plant)
}