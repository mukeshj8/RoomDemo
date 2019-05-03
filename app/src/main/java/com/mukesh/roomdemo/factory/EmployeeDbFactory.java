package com.mukesh.roomdemo.factory;

import com.mukesh.roomdemo.models.Employee;

import java.util.List;

public interface EmployeeDbFactory {

    void saveEmp(Employee employee);
    void getEmp(String empId);
    void getAllEmp();
    void deleteEmp(String empID);
    void deleteAllEmp();

}
