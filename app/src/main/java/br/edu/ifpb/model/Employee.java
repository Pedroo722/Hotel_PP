package br.edu.ifpb.model;

import java.time.LocalTime;

import br.edu.ifpb.interfaces.EmployeeIF;

public class Employee implements EmployeeIF {
    int userId;
    String name, password, role;
    LocalTime workSchedule; 

    public Employee(int userId, String name, String password, String role, LocalTime workSchedule) {
        this,userId = userId;
        this.name = name;
        this.password = password;
        this.role = role;
        this.workSchedule = workSchedule;
    }

    public Employee returnEmployee(int userId) {
        if (this.userId == userId) {
            return this;
        } 
        return null;
    }
}
