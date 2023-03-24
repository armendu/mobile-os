package com.example.e0601roomproject.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "riinvest_students")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="surname") val surname: String,
    @ColumnInfo(name="gender") val gender: String?
)