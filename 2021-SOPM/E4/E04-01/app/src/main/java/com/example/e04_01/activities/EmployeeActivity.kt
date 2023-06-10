package com.example.e04_01.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e04_01.R
import com.example.e04_01.adapters.EmployeesAdapter
import com.example.e04_01.enums.Gender
import com.example.e04_01.enums.Role
import com.example.e04_01.viewmodels.EmployeeViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EmployeeActivity : AppCompatActivity() {
    private val TAG = "EmployeeActivity"
    private val mDatabase: FirebaseDatabase? = null
    private val employeeList: MutableList<EmployeeViewModel?> = ArrayList()
    private var firebaseDatabase: FirebaseDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        firebaseDatabase =
            FirebaseDatabase.getInstance("https://example04-360e1-default-rtdb.europe-west1.firebasedatabase.app/")
        val ref = firebaseDatabase!!.getReference("users")
        val employeesAdapter = EmployeesAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = employeesAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        employeesAdapter.setData(employeeList)
        val fab = findViewById<FloatingActionButton>(R.id.floating_action_button)
        fab.setOnClickListener { view: View? ->
            val firstEmployee =
                EmployeeViewModel("Armend", "Riinvest1", "", Gender.Male, Role.Technology)
            val key = ref.push().key // produces: "-McVBXTtwELzvmnDLwIm" : {}
            ref.child(key!!).setValue(firstEmployee) // {}
        }
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                employeeList.clear()
                for (childData in snapshot.children) {
                    Log.d(TAG, "Child data has value: $childData")
                    val evm = childData.getValue(
                        EmployeeViewModel::class.java
                    )
                    employeeList.add(evm)
                }
                employeesAdapter.setData(employeeList)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, "Error: $error")
            }
        })
    }
}