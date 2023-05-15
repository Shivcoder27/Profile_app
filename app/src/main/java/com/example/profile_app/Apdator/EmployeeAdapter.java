package com.example.profile_app.Apdator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.profile_app.R;
import  com.example.profile_app.Apdator.EmployeeHolder;
import com.example.profile_app.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {
    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    private List<Employee> employeeList;

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
      Employee employee = employeeList.get(position);
      holder.name.setText(employee.getName());
      holder.location.setText(employee.getLocation());
      holder.branch.setText(employee.getBranch());

    }

    @Override
    public int getItemCount() {
      return employeeList.size();
    }
}
