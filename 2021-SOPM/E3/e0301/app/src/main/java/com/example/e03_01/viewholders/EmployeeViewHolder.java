package com.example.e03_01.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e03_01.R;
import com.example.e03_01.viewmodels.Employee;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private TextView employeeNameTextView;
    private TextView employeeRoleTextView;
    private TextView employeeDescriptionTextView;
    private TextView employeeGenderTextView;

    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);

        employeeNameTextView = itemView.findViewById(R.id.employee_name);
        employeeRoleTextView = itemView.findViewById(R.id.employee_role);
        employeeDescriptionTextView = itemView.findViewById(R.id.employee_description);
        employeeGenderTextView = itemView.findViewById(R.id.employee_gender);
    }

    public void bindData(Employee employee) {
        employeeNameTextView.setText(employee.getName());
        employeeRoleTextView.setText(employee.getRole().getDescription());
        employeeDescriptionTextView.setText(employee.getDescription());
        employeeGenderTextView.setText(employee.getGender().getDescription());
    }
}
