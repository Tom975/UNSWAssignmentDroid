package com.example.z5056635.assignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.z5056635.assignment.Databases.DriverTable;
import com.example.z5056635.assignment.Databases.ExpenseTable;
import com.example.z5056635.assignment.Databases.LogTable;
import com.example.z5056635.assignment.Databases.TripTable;
import com.example.z5056635.assignment.Databases.VehicleTable;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class DBReaderHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LogBook.db";

    public DBReaderHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DriverTable.SQL_CREATE_ENTRIES);
        db.execSQL(ExpenseTable.SQL_CREATE_ENTRIES);
        db.execSQL(LogTable.SQL_CREATE_ENTRIES);
        db.execSQL(TripTable.SQL_CREATE_ENTRIES);
        db.execSQL(VehicleTable.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DriverTable.SQL_DELETE_ENTRIES);
        db.execSQL(ExpenseTable.SQL_DELETE_ENTRIES);
        db.execSQL(LogTable.SQL_DELETE_ENTRIES);
        db.execSQL(TripTable.SQL_DELETE_ENTRIES);
        db.execSQL(VehicleTable.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onOpen(SQLiteDatabase db) {
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}