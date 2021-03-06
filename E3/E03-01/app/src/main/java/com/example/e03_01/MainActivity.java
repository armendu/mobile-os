package com.example.e03_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e03_01.adapters.EmployeesAdapter;
import com.example.e03_01.enums.Gender;
import com.example.e03_01.enums.Role;
import com.example.e03_01.viewmodels.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeesAdapter employeesAdapter = new EmployeesAdapter();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(employeesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        List<Employee> employeeList = new ArrayList<Employee>(Arrays.asList());
        Employee newEmployee = new Employee();
        newEmployee.setName("Armend");
        newEmployee.setGender(Gender.Male);
        newEmployee.setRole(Role.Technology);
        employeeList.add(newEmployee);
        employeesAdapter.setData(employeeList);
    }
}