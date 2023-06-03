package com.example.classstudentmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG, "Called onCreate")

        // Initialize Firebase Auth
        auth = Firebase.auth

        val button = findViewById<Button>(R.id.login_button)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        button.setOnClickListener {
            if (email.text.isNullOrEmpty() || password.text.isNullOrEmpty()) {
                Toast.makeText(this, "Username or Password is empty", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showLongToastWithMessage("Logged in successfully. Hello ${auth.currentUser?.email}")
                        val intent = Intent(this, PostsActivity::class.java)
                        intent.putExtra("USERNAME", email.text.toString())
                        startActivity(intent)
                        finish()
                    } else {
                        showLongToastWithMessage("Authentication failed: ${task.exception}")
                    }
                }
        }

        val registerButton = findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener {
            createUserWith(email, password)
        }
    }

    private fun showLongToastWithMessage(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun createUserWith(username: EditText, password: EditText) {
        auth.createUserWithEmailAndPassword(username.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    Log.d(TAG, "onCreate: Current User has the following: ${user?.email}")
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    showLongToastWithMessage("Authentication failed.")
                }
            }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Called onStart")

        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            Log.d(TAG, "onStart: Current user is: ${currentUser.email}")
            showLongToastWithMessage("Logged in successfully. Hello ${currentUser.email}")
            val intent = Intent(this, PostsActivity::class.java)
            intent.putExtra("ID", currentUser.uid.toString())
            startActivity(intent)
            finish()
        } else {
            Log.d(TAG, "onStart: User is not logged in")
        }
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