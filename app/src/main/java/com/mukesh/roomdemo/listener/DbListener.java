package com.mukesh.roomdemo.listener;

import com.mukesh.roomdemo.models.Employee;

import java.util.List;

public interface DbListener {

    void onGet(Employee arg);

    void onGetAll(List<Employee> arg);

    void onUpdate(boolean arg);

    void onDelete(boolean arg);

    void onDeleteAll(boolean arg);

    void onSave(boolean arg);

}
