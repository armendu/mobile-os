package com.example.recyclerviewexercise.viewmodels

import com.example.recyclerviewexercise.enums.Gender

data class StudentViewModel(
    val name: String,
    val surname: String,
    val gender: Gender
)
