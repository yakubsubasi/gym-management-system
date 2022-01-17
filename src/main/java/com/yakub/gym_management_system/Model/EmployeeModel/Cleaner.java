package com.yakub.gym_management_system.Model.EmployeeModel;

public class Cleaner extends Employee{


    public Cleaner(String id, String name,  String email, String role, String salary) {
        super(id, name, email, salary);
        super.setRole(role);
    }
}
