package com.example.recyclerviewexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexercise.adapters.StudentsAdapter
import com.example.recyclerviewexercise.enums.Gender
import com.example.recyclerviewexercise.viewmodels.StudentViewModel

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentsAdapter = StudentsAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = studentsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val students = ArrayList<StudentViewModel>()
        students.add(StudentViewModel("Armend", "Ukehaxhaj", Gender.Male))
        students.add(StudentViewModel("Armend1", "Ukehaxhaj1", Gender.Male))
        students.add(StudentViewModel("Armend2", "Ukehaxhaj2", Gender.Male))
        students.add(StudentViewModel("Armend3", "Ukehaxhaj3", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        students.add(StudentViewModel("Armend4", "Ukehaxhaj4", Gender.Male))
        studentsAdapter.setData(students)
    }
}