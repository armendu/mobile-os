package com.example.plantapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {

    ///Flow in Room database can keep the data up-to-date by emitting a notification
    // whenever the data in the database changes.
    // This allows you to observe the data and update your UI accordingly.
    // In coroutines, a flow is a type that can emit multiple values sequentially,
    // as opposed to suspend functions that return only a single value.
    @Query("SELECT * FROM plants WHERE uid = :uid")
    fun get(uid: Int): Flow<Plant>

    @Query("SELECT * FROM plants ORDER BY name ASC")
    fun getAll(): Flow<List<Plant>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(plant: Plant)

    @Update
    suspend fun update(plant: Plant)

    @Delete
    suspend fun delete(plant: Plant)
}