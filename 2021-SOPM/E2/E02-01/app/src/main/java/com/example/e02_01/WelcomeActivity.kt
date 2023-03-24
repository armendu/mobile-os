package com.example.e02_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e02_01.R
import android.content.Intent
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    private val FULL_NAME_KEY = "FULL_NAME_KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val mainActivityIntent = intent
        if (mainActivityIntent != null) {
            val name = mainActivityIntent.getStringExtra(FULL_NAME_KEY)
            val welcomeMessage = findViewById<TextView>(R.id.welcome_text)
            val welcomeTextToDisplay = getString(R.string.welcome_text, name)
            welcomeMessage.text = welcomeTextToDisplay
        }
    }
}