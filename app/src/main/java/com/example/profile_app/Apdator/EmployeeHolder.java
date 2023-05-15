package com.example.profile_app.Apdator;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.profile_app.R;

public class EmployeeHolder extends RecyclerView.ViewHolder {
   TextView name,location,branch;
    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.rv_name);
        location = itemView.findViewById(R.id.rv_location);
        branch = itemView.findViewById(R.id.rv_branch);

    }
}
