package com.example.classstudentmanagement

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.classstudentmanagement.models.Course
import com.example.classstudentmanagement.models.Student
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

class PublishActivity : AppCompatActivity() {

    companion object {
        const val TAG = "PublishActivity"
    }

    // Reference to Storage
    private val storage = Firebase.storage
    // Create a storage reference from our app
    private val storageRef = storage.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish)

        val loginActivityIntent = intent
        val userId = loginActivityIntent.getStringExtra("ID")
        Log.d("PublishActivity", "Id is ${userId.toString()}")

        val name = findViewById<EditText>(R.id.name)
        val surname = findViewById<EditText>(R.id.surname)
        val addButton = findViewById<Button>(R.id.add_button)
        val addUserInfo = findViewById<Button>(R.id.add_user_info)
        val downloadImageButton = findViewById<Button>(R.id.download_image)
        val uploadImageButton = findViewById<Button>(R.id.upload_image)

        // Get database
        val database = Firebase.database

        // Courses Reference
        val coursesReference = database.getReference("courses")

        // Users Reference
        val usersReference = database.getReference("users")

        usersReference.child(userId!!).get()
            .addOnSuccessListener {
                Log.i("PublishActivity", "Got value ${it.value}")
            }.addOnFailureListener {
                Log.e("PublishActivity", "Error getting data", it)
            }

        addButton.setOnClickListener {
            addNewCourse(name, surname, coursesReference)
        }

        addUserInfo.setOnClickListener {
            addNewStudent(usersReference, userId)
        }

        downloadImageButton.setOnClickListener {
            getImageFromStorage()
        }

        uploadImageButton.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    private fun getImageFromStorage() {
        storageRef.child("image:17").downloadUrl.addOnSuccessListener { uri ->
            // Local temp file has been created
            Log.d(TAG, "Download URL for that file is: $uri")

            val imageView = findViewById<ImageView>(R.id.image_view)
            Glide.with(this)
                .load(uri)
                .into(imageView)
        }.addOnFailureListener { exception ->
            // Handle any errors
            Log.d(TAG, "Download URL for that file FAILED: ${exception.message}")
        }
    }

    private fun addNewStudent(
        usersReference: DatabaseReference,
        userId: String?
    ) {
        val student = Student(1, "Name", "Surname", "Birthday")
        usersReference.child(userId!!).setValue(student)
    }

    private fun addNewCourse(
        name: EditText,
        surname: EditText,
        coursesReference: DatabaseReference
    ) {
        val courseToAdd = Course(1, name.text.toString(), surname.text.toString(), "otherDesc")
        val id = coursesReference.push().key
        coursesReference.child(id!!).setValue(courseToAdd)
    }

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        Log.d(TAG, "Uri is $uri")

        val imagesRef: StorageReference = storageRef.child(uri!!.lastPathSegment.toString())
        imagesRef.putFile(uri)
            .addOnSuccessListener {
                Toast.makeText(this, "Image was successfully uploaded", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Image FAILED to upload with message: ${exception.message}", Toast.LENGTH_LONG).show()
            }
    }
}