package com.example.profile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.profile_app.Retrofit.EmployeeApi;
import com.example.profile_app.Retrofit.RetrofitService;
import com.example.profile_app.model.Employee;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextInputEditText inputEditName,inputEditLocation,inputEditBranch;
Button saveButton,all_empl_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditName = findViewById(R.id.form_textFieldName);
        inputEditLocation = findViewById(R.id.form_textFieldLocation);
        inputEditBranch = findViewById(R.id.form_textFieldBranch    );
   saveButton  = findViewById(R.id.form_buttonSave);
   all_empl_data = findViewById(R.id.form_get_all);
   all_empl_data.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent = new Intent(MainActivity.this,EmployeeListActivity.class);
           startActivity(intent);
       }
   });


        RetrofitService retrofitService = new RetrofitService();
    EmployeeApi employeeApi=    retrofitService.getRetrofit().create(EmployeeApi.class);
   saveButton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           String name =String.valueOf(inputEditName.getText()) ;
           String location = String.valueOf(inputEditLocation.getText()) ;
           String branch = String.valueOf(inputEditBranch.getText()) ;

           Employee employee = new Employee();
           employee.setName(name);
           employee.setLocation(location);
           employee.setBranch(branch);
employeeApi.save(employee).enqueue(new Callback<Employee>() {
    @Override
    public void onResponse(Call<Employee> call, Response<Employee> response) {
        Toast.makeText(MainActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<Employee> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Failed to save data", Toast.LENGTH_SHORT).show();
        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,"error Occurred");
    }
});
       }
   });


    }
}