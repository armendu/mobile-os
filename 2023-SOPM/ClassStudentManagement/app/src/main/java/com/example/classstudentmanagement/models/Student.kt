package com.example.classstudentmanagement.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("students")
data class Student(
    @PrimaryKey(true)
    val id: Int,
    @ColumnInfo(name = "student_name")
    val name: String,
    val surname: String,
    val birthday: String
)