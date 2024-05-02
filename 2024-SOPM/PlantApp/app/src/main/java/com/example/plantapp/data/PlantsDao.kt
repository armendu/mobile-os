package com.example.plantapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantsDao {

    @Query("SELECT * FROM plants WHERE uid = :uid")
    fun get(uid: Int): Flow<Plant?>

    @Query("SELECT * FROM plants ORDER BY plant_name ASC")
    fun getAll(): Flow<List<Plant>>

    @Insert
    suspend fun insert(plant: Plant)

    @Update
    suspend fun update(plant: Plant)

    @Delete
    suspend fun delete(plant: Plant)
}