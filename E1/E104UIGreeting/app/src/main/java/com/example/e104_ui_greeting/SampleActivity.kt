package com.example.e104_ui_greeting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SampleActivity : AppCompatActivity() {
    val testingString: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        // Defined the value of testing string

        testingString!!.chars()
    }
}