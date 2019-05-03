package com.mukesh.roomdemo.db;

import android.arch.persistence.room.Room;
import android.content.Context;

import static com.mukesh.roomdemo.db.AppDatabase.MIGRATION_2_3;
import static com.mukesh.roomdemo.db.AppDatabase.MIGRATION_3_4;

public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;

    //our app database object
    private AppDatabase appDatabase;

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;
        //creating the app database with Room database builder
        //MMTs is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "DemoRoom").addMigrations(MIGRATION_2_3, MIGRATION_3_4).build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

}
