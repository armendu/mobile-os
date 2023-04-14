package com.example.classstudentmanagement

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.classstudentmanagement.adapters.CoursesAdapter
import com.example.classstudentmanagement.data.DataSource
import com.example.classstudentmanagement.models.Course
import com.example.classstudentmanagement.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ContentActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "ContentActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val mainActivityIntent = intent

        val username = mainActivityIntent.getStringExtra("USERNAME")
        Log.d("ContentActivity", "Username is ${username.toString()}")

        val coursesList = DataSource().getCourses()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val service = ApiService.getService().getCourses()

        service.enqueue(object : Callback<List<Course>> {
            override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                Log.d(TAG, "Response success: " + response.body().toString())

                if (response.isSuccessful) {
                    recyclerView.adapter = CoursesAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                Log.d(TAG, "Response failed: " + t.message.toString())
            }
        })
    }
}