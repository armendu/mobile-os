package com.example.e08_fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e08_fragmentexample.packages.RecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val listDataManager = StudentDataManager(this)
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Setup the adapter
        recyclerView.adapter = RecyclerAdapter()

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            showCreateListDialog()
        }
    }

    private fun showCreateListDialog() {
        val builder = AlertDialog.Builder(this)
        val nameEditText = EditText(this)
        nameEditText.inputType = InputType.TYPE_CLASS_TEXT

        val dialogTitle = getString(R.string.dialog_title)

        builder.setTitle(dialogTitle)
        builder.setView(nameEditText)

        builder.setPositiveButton("Confirm") { dialog, i ->
            dialog.dismiss()
        }

        builder.create().show()
    }
}