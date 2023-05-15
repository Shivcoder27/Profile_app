package com.example.profile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.profile_app.Apdator.EmployeeAdapter;
import com.example.profile_app.Apdator.EmployeeHolder;
import com.example.profile_app.Retrofit.EmployeeApi;
import com.example.profile_app.Retrofit.RetrofitService;
import com.example.profile_app.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeListActivity extends AppCompatActivity {
 private RecyclerView recyclerView ;
// private List<Employee> employeeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
  recyclerView = findViewById(R.id.employeeList_Rv);
  recyclerView.setLayoutManager(new LinearLayoutManager(this));
  loadEmployees();
    }

    private void loadEmployees() {
        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);
        employeeApi.getAllEmployees()
                .enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        populatedListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        Toast.makeText(EmployeeListActivity.this, "Failed to load", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populatedListView(List<Employee> body) {
        EmployeeAdapter employeeAdapter = new EmployeeAdapter(body);
        recyclerView.setAdapter(employeeAdapter);
        employeeAdapter.notifyDataSetChanged();
    }



}