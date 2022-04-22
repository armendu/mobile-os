package com.example.e02_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e02_01.R
import android.widget.EditText
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.e02_01.WelcomeActivity

class MainActivity : AppCompatActivity() {
    val FULL_NAME_KEY = "FULL_NAME_KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val submitButton = findViewById<Button>(R.id.submit_button)
        val submittedName = findViewById<EditText>(R.id.full_name)
        submitButton.setOnClickListener { view: View? ->
            val fullName = submittedName.text.toString().trim { it <= ' ' }
            if (!fullName.isEmpty()) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra(FULL_NAME_KEY, fullName)
                startActivity(intent)
            }
        }
    }
}