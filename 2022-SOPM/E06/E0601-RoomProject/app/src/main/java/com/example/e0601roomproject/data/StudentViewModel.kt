package com.example.e0601roomproject.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class StudentViewModel(private val studentRepository: StudentRepository) : ViewModel() {
    val students: LiveData<List<Student>> = studentRepository.allStudents.asLiveData()
}