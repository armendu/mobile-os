package com.example.e04_01.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e04_01.R;
import com.example.e04_01.adapters.EmployeesAdapter;
import com.example.e04_01.enums.Gender;
import com.example.e04_01.enums.Role;
import com.example.e04_01.viewmodels.EmployeeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    private String TAG = "EmployeeActivity";
    private FirebaseDatabase mDatabase;

    private List<EmployeeViewModel> employeeList = new ArrayList<EmployeeViewModel>();
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        firebaseDatabase = FirebaseDatabase.getInstance("https://example04-360e1-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference ref = firebaseDatabase.getReference("users");

        EmployeesAdapter employeesAdapter = new EmployeesAdapter();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(employeesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        employeesAdapter.setData(employeeList);

        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(view -> {
            EmployeeViewModel firstEmployee = new
                    EmployeeViewModel("Armend", "Riinvest1", "", Gender.Male, Role.Technology);

            String key = ref.push().getKey(); // produces: "-McVBXTtwELzvmnDLwIm" : {}
            ref.child(key).setValue(firstEmployee); // {}
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                employeeList.clear();
                for (DataSnapshot childData : snapshot.getChildren()) {
                    Log.d(TAG, "Child data has value: " + String.valueOf(childData));
                    EmployeeViewModel evm = childData.getValue(EmployeeViewModel.class);
                    employeeList.add(evm);
                }

                employeesAdapter.setData(employeeList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "Error: " + error);
            }
        });
    }
}