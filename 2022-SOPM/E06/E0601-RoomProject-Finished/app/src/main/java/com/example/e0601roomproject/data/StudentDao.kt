package com.example.e0601roomproject.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Query("SELECT * FROM riinvest_students")
    fun getAllStudents(): Flow<List<Student>>

    @Query("SELECT * FROM riinvest_students WHERE id = :id")
    fun getStudent(id: Int) : Flow<Student>

    @Insert
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)
}