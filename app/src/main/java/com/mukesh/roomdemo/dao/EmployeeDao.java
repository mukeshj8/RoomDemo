package com.mukesh.roomdemo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mukesh.roomdemo.models.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Employee employee);

    @Query("SELECT * FROM employee WHERE empId = :empID")
    Employee get(String empID);

    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    @Query("DELETE FROM employee WHERE empId = :empID")
    void delete(String empID);

    @Query("DELETE FROM employee")
    void deleteAll();

}
