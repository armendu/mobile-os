package com.example.e0601roomproject.data

import com.example.e0601roomproject.services.TypicodeService
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

class StudentRepository(private val studentDao: StudentDao, private val typicodeService: TypicodeService) {
    val allStudents: Flow<List<Student>> = studentDao.getAllStudents()

    fun getTodo(id: Int): Call<Todo> {
        return typicodeService.getTodo(id)
    }
}