package com.example.e04_1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e04_1.adapters.EmployeesAdapter;
import com.example.e04_1.enums.Gender;
import com.example.e04_1.enums.Role;
import com.example.e04_1.viewmodels.EmployeeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContentActivity extends AppCompatActivity {

    private final String TAG = "ContentActivity";
    private List<EmployeeViewModel> employeeViewModels = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeesAdapter employeesAdapter = new EmployeesAdapter();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(employeesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            EmployeeViewModel firstEmployee = new EmployeeViewModel("Armend", "Riinvest", "", Gender.Male, Role.Technology);
//            employeeViewModels.add(firstEmployee);
//            employeesAdapter.setData(employeeViewModels);
            firebaseDatabase = FirebaseDatabase.getInstance("https://example04-360e1-default-rtdb.europe-west1.firebasedatabase.app/");
            DatabaseReference ref = firebaseDatabase.getReference("users");

            String key = ref.push().getKey();
            ref.child(key).setValue(firstEmployee);
        });
    }
}