package com.mukesh.roomdemo.factory;

import android.content.Context;
import android.os.AsyncTask;

import com.mukesh.roomdemo.db.DatabaseClient;
import com.mukesh.roomdemo.listener.DbListener;
import com.mukesh.roomdemo.models.Employee;

import java.util.List;

public class EmployeeDbFactoryImpl implements EmployeeDbFactory {

    private static final String TAG = EmployeeDbFactoryImpl.class.getSimpleName();
    private Context mContext;
    private DbListener mListener;

    public EmployeeDbFactoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    public void setDbListener(DbListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void saveEmp(final Employee employee) {

        class SaveEmployee extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                //adding to database
                DatabaseClient.getInstance(mContext).getAppDatabase()
                        .employeeDao()
                        .insert(employee);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mListener.onSave(true);
            }
        }

        SaveEmployee se = new SaveEmployee();
        se.execute();

    }

    @Override
    public void getEmp(final String empId) {
        class GetEmp extends AsyncTask<Void, Void, Employee> {

            @Override
            protected Employee doInBackground(Void... voids) {
                Employee employee = DatabaseClient
                        .getInstance(mContext)
                        .getAppDatabase()
                        .employeeDao()
                        .get(empId);
                return employee;
            }

            @Override
            protected void onPostExecute(Employee employee) {
                super.onPostExecute(employee);
                mListener.onGet(employee);
            }
        }

        GetEmp ge = new GetEmp();
        ge.execute();
    }

    @Override
    public void getAllEmp() {

        class GetEmps extends AsyncTask<Void, Void, List<Employee>> {

            @Override
            protected List<Employee> doInBackground(Void... voids) {
                List<Employee> employeeList = DatabaseClient
                        .getInstance(mContext)
                        .getAppDatabase()
                        .employeeDao()
                        .getAll();
                return employeeList;
            }

            @Override
            protected void onPostExecute(List<Employee> employeeList) {
                super.onPostExecute(employeeList);
                mListener.onGetAll(employeeList);
            }
        }

        GetEmps ges = new GetEmps();
        ges.execute();

    }


    @Override
    public void deleteEmp(final String empID) {

        class DeleteEmp extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient
                        .getInstance(mContext)
                        .getAppDatabase()
                        .employeeDao()
                        .delete(empID);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mListener.onDelete(true);
            }
        }

        DeleteEmp de = new DeleteEmp();
        de.execute();

    }

    @Override
    public void deleteAllEmp() {

        class DeleteEmps extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient
                        .getInstance(mContext)
                        .getAppDatabase()
                        .employeeDao()
                        .deleteAll();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mListener.onDeleteAll(true);
            }
        }

        DeleteEmps des = new DeleteEmps();
        des.execute();

    }
}
