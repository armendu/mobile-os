package com.example.e0601roomproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class StudentViewModel(private val studentRepository: StudentRepository) : ViewModel() {
    val students: LiveData<List<Student>> = studentRepository.allStudents.asLiveData()
}