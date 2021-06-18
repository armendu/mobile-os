package com.example.e04_01.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e04_01.R;
import com.example.e04_01.adapters.EmployeesAdapter;
import com.example.e04_01.viewmodels.EmployeeViewModels;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    private String TAG = "EmployeeActivity";
    private FirebaseDatabase mDatabase;

    private List<EmployeeViewModels> employeeList = new ArrayList<EmployeeViewModels>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        mDatabase = FirebaseDatabase.getInstance("https://example04-360e1-default-rtdb.europe-west1.firebasedatabase.app/");
//        DatabaseReference myRef = mDatabase.getReference("users");
//
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });

//        myRef.setValue("Hello, World!");

        EmployeesAdapter employeesAdapter = new EmployeesAdapter();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(employeesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        employeesAdapter.setData(employeeList);
    }
}