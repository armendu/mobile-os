package com.example.classstudentmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Called onCreate")

        val button = findViewById<Button>(R.id.login_button)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        button.setOnClickListener {
            if (username.text.isNullOrEmpty() || password.text.isNullOrEmpty()) {
                Toast
                    .makeText(this, "Username or Password is empty", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }

            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("USERNAME", username.text.toString())
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Called onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Called onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Called onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Called onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Called onDestroy")
    }
}