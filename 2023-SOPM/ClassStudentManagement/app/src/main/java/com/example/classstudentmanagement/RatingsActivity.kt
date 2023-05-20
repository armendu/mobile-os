package com.example.classstudentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.classstudentmanagement.databinding.ActivityRatingsBinding
import com.example.classstudentmanagement.viewmodels.RatingsViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.database.ktx.values
import com.google.firebase.ktx.Firebase

class RatingsActivity : AppCompatActivity() {

    companion object {
        const val TAG = "RatingsActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Write a message to the database// Write a message to the database
        val database = Firebase.database

        val myRef = database.getReference("message")
        myRef.setValue("Hello World")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        val binding: ActivityRatingsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_ratings)

        binding.lifecycleOwner = this
        binding.viewmodel = RatingsViewModel()
    }
}