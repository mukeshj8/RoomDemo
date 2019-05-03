package com.mukesh.roomdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mukesh.roomdemo.adapters.EmployeeAdapter;
import com.mukesh.roomdemo.databinding.ActivityMainBinding;
import com.mukesh.roomdemo.factory.EmployeeDbFactoryImpl;
import com.mukesh.roomdemo.listener.DbListener;
import com.mukesh.roomdemo.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private EmployeeDbFactoryImpl mEmployeeDbFactory;

    private EmployeeAdapter mAdapter;
    private List<Employee> mEmployeeList = new ArrayList<>();
    private LinearLayoutManager mLayoutManager;

    private String empId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void init() {
        mEmployeeDbFactory = new EmployeeDbFactoryImpl(this);
        mEmployeeDbFactory.setDbListener(mDbListener);
        mBinding.bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEmp();
            }
        });

        mLayoutManager = new LinearLayoutManager(this);
        mBinding.recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EmployeeAdapter(this, mEmployeeList);
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mBinding.recyclerView.setAdapter(mAdapter);
        mEmployeeDbFactory.getAllEmp();
    }

    private DbListener mDbListener = new DbListener() {
        @Override
        public void onGet(Employee arg) {
            showMessage("Get");
            mEmployeeList.add(arg);
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onGetAll(List<Employee> arg) {
            showMessage("Get All");
            if (arg != null){
                mEmployeeList = arg;
                mAdapter.updateResult(mEmployeeList);
            }
        }

        @Override
        public void onUpdate(boolean arg) {
            showMessage("Updated: " + arg);
        }

        @Override
        public void onDelete(boolean arg) {
            showMessage("Deleted: " + arg);
        }

        @Override
        public void onDeleteAll(boolean arg) {
            showMessage("Deleted All: " + arg);
        }

        @Override
        public void onSave(boolean arg) {
            showMessage("Saved: " + arg);
            mEmployeeDbFactory.getEmp(empId);
        }
    };

    private void saveEmp() {
        try {
            empId = mBinding.etEmpId.getText().toString().trim();
            String empName = mBinding.etEmpName.getText().toString().trim();
            String empDsg = mBinding.etDsg.getText().toString().trim();
            double empSal = Double.parseDouble(mBinding.etSalary.getText().toString().trim());
            int empAge = Integer.parseInt(mBinding.etAge.getText().toString().trim());

            mEmployeeDbFactory.saveEmp(new Employee(empId, empName, empDsg, empSal, empAge, "12/04/1988", "20/05/2019", "Male"));

            Toast.makeText(getApplicationContext(), empId + ", " + empName + ", " + empDsg + ", " + empSal + ", " + empAge, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
