package com.example.e08_fragmentexample

class StudentViewModel(private val studentDataManager: StudentDataManager) {
    val students: List<String> = studentDataManager.readList()

    fun insertToList(value: String) {
        studentDataManager.saveList(value)
    }
}