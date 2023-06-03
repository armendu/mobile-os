package com.example.classstudentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.classstudentmanagement.adapters.PostsAdapter
import com.example.classstudentmanagement.adapters.StudentAdapter
import com.example.classstudentmanagement.application.ClassStudentManagementApplication
import com.example.classstudentmanagement.models.Course
import com.example.classstudentmanagement.models.Post
import com.example.classstudentmanagement.viewmodels.StudentViewModel
import com.example.classstudentmanagement.viewmodels.StudentViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class PostsActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "PostsActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        // Get database
        val database = Firebase.database
        // Posts Reference
        val postsRef = database.getReference("posts")

        val fab = findViewById<FloatingActionButton>(R.id.post_fab)
        fab.setOnClickListener {
            val postToAdd = Post() //"simple title123", "simple subtitle123"
            val id = postsRef.push().key
            postsRef.child(id!!).setValue(postToAdd)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.posts_recycler_view)
        val postsAdapter = PostsAdapter()
        recyclerView.adapter = postsAdapter

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val posts = dataSnapshot.getValue<HashMap<String, Post>>()

                if (posts != null) {
                    postsAdapter.submitList(posts.values.toList())
                    for (post in posts) {
                        Log.d(TAG, "Post title is ${post.value.postTitle}")
                    }
                }
                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        postsRef.addValueEventListener(postListener)
    }
}