package com.mukesh.roomdemo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mukesh.roomdemo.R;
import com.mukesh.roomdemo.models.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmpViewHolder> {

    private static final String TAG = EmployeeAdapter.class.getSimpleName();
    private Context mContext;
    private List<Employee> mEmployeeList;

    public EmployeeAdapter(Context mContext, List<Employee> mEmployeeList) {
        this.mContext = mContext;
        this.mEmployeeList = mEmployeeList;
    }

    public void updateResult(List<Employee> mEmployeeList) {
        this.mEmployeeList = mEmployeeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmpViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_emp, viewGroup, false);
        return new EmpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpViewHolder empViewHolder, int i) {

        Employee emp = mEmployeeList.get(i);
        empViewHolder.empIdTV.setText("Id: "+emp.getEmpId()+" "+emp.getGender());
        empViewHolder.empNameTV.setText("Name: "+emp.getEmpName());
        empViewHolder.dsgTV.setText("Desg: "+emp.getDesg());
        empViewHolder.salTV.setText("Salary: "+String.valueOf(emp.getSalary()));
        empViewHolder.ageTV.setText("Age: "+String.valueOf(emp.getAge()));
        empViewHolder.dobTV.setText("DOB: "+emp.getDob());
        empViewHolder.dojTV.setText("DOJ: "+emp.getDoj());

    }

    @Override
    public int getItemCount() {
        return mEmployeeList == null ? 0 : mEmployeeList.size();
    }

    class EmpViewHolder extends RecyclerView.ViewHolder {
        TextView empIdTV, empNameTV, dsgTV, salTV, ageTV, dobTV, dojTV;
        public EmpViewHolder(@NonNull View itemView) {
            super(itemView);
            empIdTV = (TextView)itemView.findViewById(R.id.tv_empid);
            empNameTV = (TextView)itemView.findViewById(R.id.tv_emp_name);
            dsgTV = (TextView)itemView.findViewById(R.id.tv_dsg);
            salTV = (TextView)itemView.findViewById(R.id.tv_salary);
            ageTV = (TextView)itemView.findViewById(R.id.tv_age);
            dobTV = (TextView)itemView.findViewById(R.id.tv_dob);
            dojTV = (TextView)itemView.findViewById(R.id.tv_doj);
        }
    }

}
