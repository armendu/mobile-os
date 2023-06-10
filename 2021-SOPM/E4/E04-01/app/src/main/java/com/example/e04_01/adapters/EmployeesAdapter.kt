package com.example.e04_01.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e04_01.R
import com.example.e04_01.viewholders.EmployeeViewHolder
import com.example.e04_01.viewmodels.EmployeeViewModel

class EmployeesAdapter : RecyclerView.Adapter<EmployeeViewHolder>() {
    private val employeeViewModels: MutableList<EmployeeViewModel?> = ArrayList()
    fun setData(employeeData: List<EmployeeViewModel?>?) {
        employeeViewModels.clear()
        employeeViewModels.addAll(employeeData!!)
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_item, parent, false)
        return EmployeeViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.bindData(employeeViewModels[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return employeeViewModels.size
    }
}