package com.example.profile_app.model;



public class Employee {


    private int id;
    private String name;
    private String location;
    private String branch;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", branch=" + branch + "]";
    }
    public Employee(int id, String name, String location, String branch) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.branch = branch;
    }
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

}