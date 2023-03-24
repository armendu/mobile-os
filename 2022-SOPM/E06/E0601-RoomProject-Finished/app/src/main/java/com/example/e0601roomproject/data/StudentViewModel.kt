package com.example.e0601roomproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StudentViewModel(private val studentRepository: StudentRepository) : ViewModel() {
    val students: LiveData<List<Student>> = studentRepository.allStudents.asLiveData()

    fun insert(student: Student) = viewModelScope.launch {
        studentRepository.insertStudent(student)
    }
}