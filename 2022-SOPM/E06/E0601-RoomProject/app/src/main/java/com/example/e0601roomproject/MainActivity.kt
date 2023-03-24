package com.example.e0601roomproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e0601roomproject.adapters.StudentAdapter
import com.example.e0601roomproject.data.*
import com.example.e0601roomproject.services.TypicodeService
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applicationScope = CoroutineScope(SupervisorJob())

        val db = StudentDatabase.getDatabase(this, applicationScope)
        val service = TypicodeService.create()
        val studentRepository = StudentRepository(db.getStudentDao(), service)

        studentRepository.getTodo(1).enqueue(object: Callback<Todo> {
            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                if (response.isSuccessful){
                    Log.d("MainActivity", "Response: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<Todo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val studentAdapter = StudentAdapter()

        recyclerView.adapter = studentAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val studentViewModel = StudentViewModel(studentRepository)

        studentViewModel.students.observe(this) { students ->
            students.let { student -> studentAdapter.submitList(student) }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val student = Student(3, "Armend1", "Ukehaxhaj", "Test")
            studentViewModel.insert(student)
        }
    }
}