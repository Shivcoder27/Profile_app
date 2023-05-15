package com.example.profile_app.Retrofit;

import com.example.profile_app.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeApi {
    @GET("/employee/get_all")
    Call<List<Employee>> getAllEmployees();

    @POST("employee/save")
    Call<Employee> save(@Body Employee employee);

}
