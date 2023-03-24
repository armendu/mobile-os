package com.example.e04_00

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.e04_00.utilities.PASSWORD_KEY
import com.example.e04_00.utilities.USERNAME_KEY

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val mainActivityIntent = intent

        val username = mainActivityIntent.getStringExtra(USERNAME_KEY)
        val password = mainActivityIntent.getStringExtra(PASSWORD_KEY)

        val welcomeMessage: TextView = findViewById(R.id.welcome_message)

        welcomeMessage.text = "Hello $username, your password is $password"
    }
}