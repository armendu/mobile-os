package com.example.classstudentmanagement

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.classstudentmanagement.adapters.CoursesAdapter
import com.example.classstudentmanagement.adapters.StudentAdapter
import com.example.classstudentmanagement.application.ClassStudentManagementApplication
import com.example.classstudentmanagement.data.DataSource
import com.example.classstudentmanagement.models.Course
import com.example.classstudentmanagement.models.Student
import com.example.classstudentmanagement.services.ApiService
import com.example.classstudentmanagement.viewmodels.StudentViewModel
import com.example.classstudentmanagement.viewmodels.StudentViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ContentActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "ContentActivity"
    }

    private val studentViewModel: StudentViewModel by viewModels {
        StudentViewModelFactory((application as ClassStudentManagementApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val mainActivityIntent = intent

        val username = mainActivityIntent.getStringExtra("USERNAME")
        Log.d("ContentActivity", "Username is ${username.toString()}")

        // val coursesList = DataSource().getCourses()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val studentAdapter = StudentAdapter()
        recyclerView.adapter = studentAdapter

        studentViewModel.students.observe(this, Observer { students ->
            students.let {
                studentAdapter.submitList(students)
                Log.d(TAG, "STUDENT Name $it")
            }
        })

        var latestId = 5

        // FAB onClick to add to DB
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            latestId += 1
            val studentToAdd =
                Student(
                    latestId,
                    "Name$latestId",
                    "surname$latestId",
                    ""
                )
            studentViewModel.insert(studentToAdd)
        }

        callServiceToGetCoursesData(recyclerView)
    }

    private fun callServiceToGetCoursesData(recyclerView: RecyclerView) {
        // Calling a Service to get Courses Data
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