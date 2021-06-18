package com.example.e04_01.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.e04_01.R;
import com.example.e04_01.adapters.EmployeesAdapter;
import com.example.e04_01.data.Employee;
import com.example.e04_01.enums.Gender;
import com.example.e04_01.enums.Role;
import com.example.e04_01.viewmodels.EmployeeViewModels;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

    private List<EmployeeViewModels> employeeList = new ArrayList<EmployeeViewModels>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        EmployeesAdapter employeesAdapter = new EmployeesAdapter();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(employeesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        employeesAdapter.setData(employeeList);

        mDatabase = FirebaseDatabase.getInstance("https://example04-360e1-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = mDatabase.getReference("users");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    Log.v(TAG,""+ childDataSnapshot.getKey()); //displays the key for the node
                    Employee employee = childDataSnapshot.getValue(Employee.class);
                    Log.v(TAG,"email: "+ employee.email);   //gives the value for given keyname
                    Log.v(TAG,"username: "+ employee.username);   //gives the value for given keyname
                    // EmployeeList is not cleared
                    employeeList.add(new EmployeeViewModels(employee.username, employee.email, employee.email, Gender.Female, Role.Technology));
                }
                employeesAdapter.setData(employeeList);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(view -> {
//            String key = mDatabase.getReference("users").getKey();

            myRef.push().setValue(new Employee("armend", "email"));
        });

//        mDatabase.getReference("users"). get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                }
//                else {
//                    Log.d("firebase", String.valueOf(task.getResult(Employee.class));
//                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                }
//            }
//        });
    }
}