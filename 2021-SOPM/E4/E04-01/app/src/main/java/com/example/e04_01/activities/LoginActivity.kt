package com.example.e04_01.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.e04_01.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()
        val usernameTextView = findViewById<TextInputEditText>(R.id.username)
        val passwordTextView = findViewById<TextInputEditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val register = findViewById<TextView>(R.id.register_text)
        register.setOnClickListener { view: View? ->
            val registerIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(registerIntent)
        }
        loginButton.setOnClickListener { view: View? ->
            val username = usernameTextView.text.toString()
            val password = passwordTextView.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please provide values", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            mAuth!!.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = mAuth!!.currentUser
                        val loginIntent = Intent(this@LoginActivity, EmployeeActivity::class.java)
                        startActivity(loginIntent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            this@LoginActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        //                                updateUI(null);
                    }
                }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
        if (currentUser != null) {
            // TODO: Start Content Activity
        }
    }
}