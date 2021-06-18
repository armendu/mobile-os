package com.example.e04_01.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e04_01.R;
import com.example.e04_01.viewholders.EmployeeViewHolder;
import com.example.e04_01.viewmodels.EmployeeViewModels;

import java.util.ArrayList;
import java.util.List;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    private final List<EmployeeViewModels> employeeViewModels = new ArrayList<>();

    public void setData(List<EmployeeViewModels> employeeData) {
        this.employeeViewModels.clear();
        this.employeeViewModels.addAll(employeeData);
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_item, parent, false);

        return new EmployeeViewHolder(view);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.bindData(employeeViewModels.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return employeeViewModels.size();
    }
}
