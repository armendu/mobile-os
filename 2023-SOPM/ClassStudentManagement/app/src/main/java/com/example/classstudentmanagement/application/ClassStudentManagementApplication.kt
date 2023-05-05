package com.example.classstudentmanagement.application

import android.app.Application
import com.example.classstudentmanagement.data.StudentRepository
import com.example.classstudentmanagement.data.UniversityDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ClassStudentManagementApplication : Application() {
    val database: UniversityDatabase by lazy {
        val applicationScope = CoroutineScope(SupervisorJob())
        UniversityDatabase.getDatabase(this, applicationScope)
    }
    val repository: StudentRepository by lazy { StudentRepository(database.studentDao) }
}