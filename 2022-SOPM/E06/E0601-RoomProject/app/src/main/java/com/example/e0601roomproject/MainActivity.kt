package com.example.e0601roomproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.e0601roomproject.data.StudentDatabase
import com.example.e0601roomproject.data.StudentRepository
import com.example.e0601roomproject.data.StudentViewModel
import com.example.e0601roomproject.data.Todo
import com.example.e0601roomproject.services.TypicodeService
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
    }
}