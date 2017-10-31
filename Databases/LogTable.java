package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

/**
 * Created by z5056635 on 18/10/2017.
 */

public class LogTable {
    private LogTable() {}

    public static class LogTableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Logs";
        public static final String COLUMN_NAME_VEHICLE = "Vehicle";
        public static final String COLUMN_NAME_DRIVER = "Driver";
        public static final String COLUMN_NAME_START_DATE = "Start_Date";
        public static final String COLUMN_NAME_END_DATE = "End_Date";
        public static final String CONSTRAINT_NAME_VEHICLE = "fk_vehicle";
        public static final String CONSTRAINT_NAME_DRIVER = "fk_driver";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + LogTableEntry.TABLE_NAME + " (" + LogTableEntry._ID + " INTEGER PRIMARY KEY, " + LogTableEntry.COLUMN_NAME_VEHICLE + " INTEGER, " +
            LogTableEntry.COLUMN_NAME_DRIVER + " INTEGER, " + LogTableEntry.COLUMN_NAME_START_DATE + " DATE, " + LogTableEntry.COLUMN_NAME_END_DATE + " DATE, CONSTRAINT " + LogTableEntry.CONSTRAINT_NAME_VEHICLE +
            " FOREIGN KEY (" + LogTableEntry.COLUMN_NAME_VEHICLE + ") REFERENCES " + VehicleTable.VehicleTableEntry.TABLE_NAME + " (" + VehicleTable.VehicleTableEntry._ID + "), CONSTRAINT " +
            LogTableEntry.CONSTRAINT_NAME_DRIVER + " FOREIGN KEY (" + LogTableEntry.COLUMN_NAME_DRIVER + ") REFERENCES " + DriverTable.DriverTableEntry.TABLE_NAME + " (" + DriverTable.DriverTableEntry._ID + "))";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + LogTableEntry.TABLE_NAME;

    /**
     * SQL compatible string for returning all rows of the Log Table
     */
    public static final String SQL_SELECT_ALL = "SELECT * FROM " + LogTableEntry.TABLE_NAME;
}