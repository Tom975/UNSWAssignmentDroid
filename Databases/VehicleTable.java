package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

/**
 * Created by z5056635 on 18/10/2017.
 */

public class VehicleTable {
    private VehicleTable() {}

    public static class VehicleTableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Vehicles";
        public static final String COLUMN_NAME_REGISTRATION = "Registration";
        public static final String COLUMN_NAME_MAKE = "Make";
        public static final String COLUMN_NAME_MODEL = "Model";
        public static final String COLUMN_NAME_YEAR = "Year";
        public static final String COLUMN_NAME_ENGINE = "Engine";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + VehicleTableEntry.TABLE_NAME +
            " (" + ExpenseTable.ExpenseTableEntry._ID + "INTEGER PRIMARY KEY," + VehicleTableEntry.COLUMN_NAME_REGISTRATION + " TEXT," +
            VehicleTableEntry.COLUMN_NAME_MAKE + " TEXT," + VehicleTableEntry.COLUMN_NAME_MODEL + " TEXT," +
            VehicleTableEntry.COLUMN_NAME_YEAR + " DATE," + VehicleTableEntry.COLUMN_NAME_ENGINE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + VehicleTableEntry.TABLE_NAME;

    /**
     * SQL compatible string for returning all rows of the Vehicle Table
     */
    public static final String SQL_SELECT_ALL = "SELECT * FROM " + VehicleTableEntry.TABLE_NAME;
}