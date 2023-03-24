package com.example.e05_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.e05_1.R
import android.widget.TextView
import com.example.e05_1.data.UserViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.e05_1.SampleService
import retrofit2.Retrofit
import com.example.e05_1.MainActivity
import retrofit2.converter.gson.GsonConverterFactory
import com.example.e05_1.Post
import com.example.e05_1.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val outTextView = findViewById<TextView>(R.id.test_view)

        // Get ViewModel
        val userViewModel = ViewModelProvider(this).get(
            UserViewModel::class.java
        )

        // Log the existing data
        userViewModel.allUsers.observe(this) { users: List<User> ->
            // adapter.setData(users);
            val builder = StringBuilder()
            outTextView.text = ""
            for (user in users) {
                builder.append(user.name).append(", ")
            }
            outTextView.text = builder.toString()
        }
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view: View? ->
            // Insert new user
            val userToAdd = User()
            val random = Random()
            val number = random.nextInt()
            userToAdd.name = "StudentiTjeter$number"
            userViewModel.createUser(userToAdd)
        }
        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SampleService::class.java)
        service.getPost(1).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    Log.d("MainActivity", "Message: " + response.body()!!.title)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {}
        })
    }

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}