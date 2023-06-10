package com.example.classstudentmanagement

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.classstudentmanagement.adapters.PostsAdapter
import com.example.classstudentmanagement.models.Post
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

        // Using shared preferences
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return

        // number_of_allowed_posts : 1000
        // update: number_of_allowed_posts = 2000

        // Writing
        with (sharedPref.edit()) {
            putInt(getString(R.string.number_of_allowed_posts), 1000)
            apply()
        }

        // Reading
        val defaultValue = resources.getInteger(R.integer.default_value)
        var numberOfPosts = sharedPref.getInt(getString(R.string.number_of_allowed_posts), defaultValue)

        Log.d(TAG, "onCreate: numberOfPosts is: $numberOfPosts")

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

        val postListener = postsValueListener(postsAdapter)
        postsRef.addValueEventListener(postListener)
    }

    private fun postsValueListener(postsAdapter: PostsAdapter) =
        object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val posts = dataSnapshot.getValue<HashMap<String, Post>>()

                if (posts != null) {
                    postsAdapter.submitList(posts.values.toList())
                    for (post in posts) {
                        Log.d(TAG, "Post title is ${post.value.postTitle}")
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
}