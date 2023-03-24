package com.example.e0601roomproject

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e0601roomproject.adapters.StudentListAdapter
import com.example.e0601roomproject.data.*
import com.example.e0601roomproject.services.TypicodeService
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = StudentDatabase.getDatabase(this)
        val service = TypicodeService.create()
        val repo = StudentRepository(db.getStudentDao(), service)

        repo.getTodo(1).enqueue(object: Callback<Todo> {
            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                if (response.isSuccessful){
                    Log.d("MainActivity", "Response: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<Todo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = StudentListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val studentViewModel = StudentViewModel(repo)
        studentViewModel.students.observe(this) { students ->
            // Update the cached copy of the words in the adapter.
            students?.let { adapter.submitList(it) }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val student = Student(2, "test123", "test123", "test123")
            studentViewModel.insert(student)
        }
    }
}