package com.mukesh.roomdemo.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "employee")
public class Employee implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "empId")
    private String empId;

    @ColumnInfo(name = "empName")
    private String empName;

    @ColumnInfo(name = "desg")
    private String desg;

    @ColumnInfo(name = "salary")
    private double salary;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name = "dob")
    private String dob;

    @ColumnInfo(name = "doj")
    private String doj;

    @ColumnInfo(name = "gender")
    private String gender;

    public Employee(@NonNull String empId, String empName, String desg, double salary, int age, String dob, String doj, String gender) {
        this.empId = empId;
        this.empName = empName;
        this.desg = desg;
        this.salary = salary;
        this.age = age;
        this.dob = dob;
        this.doj = doj;
        this.gender = gender;
    }

    @NonNull
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(@NonNull String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
