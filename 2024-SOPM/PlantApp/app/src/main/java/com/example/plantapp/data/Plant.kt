package com.example.plantapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "plant_name") val name: String,
    @ColumnInfo() val description: String?,
)
