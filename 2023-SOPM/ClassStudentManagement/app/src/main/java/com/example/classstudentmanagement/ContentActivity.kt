package com.example.classstudentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val mainActivityIntent = intent

        val username = mainActivityIntent.getStringExtra("USERNAME")
        val contentButton = findViewById<Button>(R.id.content_button)

        contentButton.text = username.toString()
    }
}