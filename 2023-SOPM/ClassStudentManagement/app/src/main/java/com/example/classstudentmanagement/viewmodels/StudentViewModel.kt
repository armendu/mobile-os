package com.example.classstudentmanagement.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.classstudentmanagement.data.StudentRepository
import com.example.classstudentmanagement.models.Student
import kotlinx.coroutines.launch

class StudentViewModel(private val studentRepository: StudentRepository): ViewModel() {
    val students = studentRepository.students.asLiveData()

    fun insert(student: Student) = viewModelScope.launch {
        studentRepository.add(student)
    }
}

class StudentViewModelFactory(private val repository: StudentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}