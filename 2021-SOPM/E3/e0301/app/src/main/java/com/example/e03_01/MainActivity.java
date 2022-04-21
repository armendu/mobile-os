package com.example.e03_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e03_01.adapters.EmployeeAdapter;
import com.example.e03_01.viewmodels.Employee;
import com.example.e03_01.viewmodels.Gender;
import com.example.e03_01.viewmodels.Role;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeeAdapter employeeAdapter = new EmployeeAdapter();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        // Get the data from the database
        List<Employee> employees =  new ArrayList<>();
        employees.add(new Employee("Test Name", "Very good programmer", Gender.Male, Role.HR));
        employees.add(new Employee("Test Name1", "Very good programmer2", Gender.Female, Role.Finance));
        employeeAdapter.setEmployees(employees);
    }
}