package com.example.e04_01.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e04_01.R
import com.example.e04_01.viewmodels.EmployeeViewModel

class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val employeeNameView: TextView
    private val employeeRoleView: TextView
    private val employeeBioView: TextView
    private val employeeGenderView: TextView

    init {
        employeeNameView = itemView.findViewById(R.id.item_employee_name)
        employeeRoleView = itemView.findViewById(R.id.item_employee_role)
        employeeBioView = itemView.findViewById(R.id.item_employee_biography)
        employeeGenderView = itemView.findViewById(R.id.item_employee_gender)
    }

    fun bindData(employeeViewModel: EmployeeViewModel?) {
        employeeNameView.text = employeeViewModel.getName()
        employeeRoleView.text = employeeViewModel.getRole().toString()
        employeeBioView.text = employeeViewModel.getBiography()
        employeeGenderView.text = employeeViewModel.getGender().description
    }
}