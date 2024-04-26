package com.example.plantapp.data

import kotlinx.coroutines.flow.Flow


interface PlantsRepository {
    fun get(uid: Int): Flow<Plant?>

    fun getAll(): Flow<List<Plant>>

    suspend fun insert(plant: Plant)

    suspend fun delete(plant: Plant)

    suspend fun update(plant: Plant)
}

class OfflinePlantsRepository(private val plantsDao: PlantDao) : PlantsRepository {
    override fun get(uid: Int): Flow<Plant?> = plantsDao.get(uid);

    override fun getAll(): Flow<List<Plant>> = plantsDao.getAll()

    override suspend fun insert(plant: Plant) = plantsDao.insert(plant)

    override suspend fun delete(plant: Plant) = plantsDao.delete(plant)

    override suspend fun update(plant: Plant) = plantsDao.update(plant)
}