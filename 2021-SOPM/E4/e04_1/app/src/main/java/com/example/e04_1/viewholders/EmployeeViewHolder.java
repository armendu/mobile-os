package com.example.e04_1.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e04_1.R;
import com.example.e04_1.viewmodels.EmployeeViewModel;

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

    public void bindData(EmployeeViewModel employeeViewModel) {
        employeeNameView.setText(employeeViewModel.getName());
        employeeRoleView.setText(employeeViewModel.getRole().toString());
        employeeBioView.setText(employeeViewModel.getBiography());
        employeeGenderView.setText(employeeViewModel.getGender().getDescription());
    }

}
