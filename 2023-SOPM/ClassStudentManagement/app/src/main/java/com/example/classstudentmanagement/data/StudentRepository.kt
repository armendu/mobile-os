package com.example.classstudentmanagement.data

import androidx.annotation.WorkerThread
import com.example.classstudentmanagement.models.Student
import kotlinx.coroutines.flow.Flow

class StudentRepository(private val studentDao: StudentDao) {
    val students: Flow<List<Student>> = studentDao.getAllStudents()

    @WorkerThread
    suspend fun add(student: Student) {
        studentDao.addStudent(student)
    }
}