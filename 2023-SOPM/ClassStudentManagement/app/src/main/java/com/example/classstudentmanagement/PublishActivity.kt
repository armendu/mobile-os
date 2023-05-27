package com.example.classstudentmanagement

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.classstudentmanagement.models.Course
import com.example.classstudentmanagement.models.Student
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.io.File
import java.io.FileInputStream


class PublishActivity : AppCompatActivity() {

    companion object {
        const val TAG = "PublishActivity"
    }

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
        val addImageButton = findViewById<Button>(R.id.add_image)
        val downloadImageButton = findViewById<Button>(R.id.download_image)

        // Get database
        val database = Firebase.database

        // Courses Reference
        val coursesReference = database.getReference("courses")

        // Users Reference
        val usersReference = database.getReference("users")

        // Reference to Storage
        val storage = Firebase.storage
        // Create a storage reference from our app
        var storageRef = storage.reference
        // Create a child reference
        // imagesRef now points to "images"
        var imagesRef: StorageReference? = storageRef.child("images")


        usersReference.child(userId!!).get().addOnSuccessListener {
            Log.i("PublishActivity", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("PublishActivity", "Error getting data", it)
        }

        addButton.setOnClickListener {
            val courseToAdd = Course(1, name.text.toString(), surname.text.toString(), "otherDesc")
            val id = coursesReference.push().key
            coursesReference.child(id!!).setValue(courseToAdd)
        }

        addUserInfo.setOnClickListener {
            val student = Student(1, "Name", "Surname", "Birthday")
            usersReference.child(userId).setValue(student)
        }

        addImageButton.setOnClickListener {
            val stream = FileInputStream(File("/Users/armend/Documents/Workspace/AndroidWorkspace/mobile-os/2023-SOPM/ClassStudentManagement/app/src/main/res/drawable/riinvest.png"))

            val uploadTask = imagesRef!!.putStream(stream)
            uploadTask.addOnFailureListener {
                Log.d(TAG, "File failed to upload")
                // Handle unsuccessful uploads
            }.addOnSuccessListener { taskSnapshot ->
                // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
                // ...
                Log.d(TAG, "File uploaded successfully")
            }
        }

        downloadImageButton.setOnClickListener {
            val ourImage = storageRef.child("Android-App-Approaches.drawio.png")

            val localFile = File.createTempFile("images", "jpg")

            ourImage.getFile(localFile).addOnSuccessListener {
                // Local temp file has been created
                Log.d(TAG, "File has been download")
            }.addOnFailureListener {
                // Handle any errors
            }
        }
    }

    fun getURLForResource(resourceId: Int): String? {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://" + R::class.java.getPackage().name + "/" + resourceId)
            .toString()
    }
}