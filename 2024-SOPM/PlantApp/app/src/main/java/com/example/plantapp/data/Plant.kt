package com.example.plantapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo() val name: String,
    @ColumnInfo() val description: String?
)
