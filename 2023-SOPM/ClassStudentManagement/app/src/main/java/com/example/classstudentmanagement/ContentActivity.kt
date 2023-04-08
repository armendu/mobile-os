package com.example.classstudentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.classstudentmanagement.adapters.CoursesAdapter
import com.example.classstudentmanagement.data.DataSource

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val mainActivityIntent = intent

        val username = mainActivityIntent.getStringExtra("USERNAME")
        Log.d("ContentActivity", "Username is ${username.toString()}")

        val coursesList = DataSource().getCourses()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = CoursesAdapter(coursesList)
    }
}