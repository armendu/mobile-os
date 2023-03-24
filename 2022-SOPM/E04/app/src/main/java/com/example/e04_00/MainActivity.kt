package com.example.e04_00

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.e04_00.utilities.PASSWORD_KEY
import com.example.e04_00.utilities.USERNAME_KEY

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.login_button)
        button.setOnClickListener {
            handleOnButtonClick()
        }
    }

    private fun handleOnButtonClick() {
        val usernameEditText: EditText = findViewById(R.id.username)
        val passwordEditText: EditText = findViewById(R.id.password)

        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        Toast.makeText(this, "Username: $username, Password: $password", Toast.LENGTH_LONG).show()

        val intent = Intent(this, ContentActivity::class.java)
        intent.putExtra(USERNAME_KEY, username)
        intent.putExtra(PASSWORD_KEY, password)
        startActivity(intent)
        finish()
    }
}