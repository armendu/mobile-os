package com.example.e04_01.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e04_01.R;
import com.example.e04_01.viewmodels.EmployeeViewModels;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private final TextView employeeNameView;
    private final TextView employeeRoleView;
    private final TextView employeeBioView;
    private final TextView employeeGenderView;

    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);

        employeeNameView = itemView.findViewById(R.id.item_employee_name);
        employeeRoleView = itemView.findViewById(R.id.item_employee_role);
        employeeBioView = itemView.findViewById(R.id.item_employee_biography);
        employeeGenderView = itemView.findViewById(R.id.item_employee_gender);
    }

    public void bindData(EmployeeViewModels employeeViewModels) {
        employeeNameView.setText(employeeViewModels.getName());
        employeeRoleView.setText(employeeViewModels.getRole().toString());
        employeeBioView.setText(employeeViewModels.getBiography());
        employeeGenderView.setText(employeeViewModels.getGender().getDescription());
    }

}
