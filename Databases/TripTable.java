package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

/**
 * Created by z5056635 on 18/10/2017.
 */

public class TripTable {
    private TripTable() {}

    public static class TripTableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Trips";
        public static final String COLUMN_NAME_LOGBOOK = "Log_Book";
        public static final String COLUMN_NAME_REGISTRATION = "Registration";
        public static final String COLUMN_NAME_MAKE = "Make";
        public static final String COLUMN_NAME_MODEL = "Model";
        public static final String COLUMN_NAME_YEAR = "Year";
        public static final String COLUMN_NAME_ENGINE = "Engine";
        public static final String CONSTRAINT_NAME_LOGBOOK = "fk_logbook";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TripTableEntry.TABLE_NAME +
            " (" + TripTableEntry._ID + "INTEGER PRIMARY KEY, " + TripTableEntry.COLUMN_NAME_LOGBOOK + " INTEGER, " + TripTableEntry.COLUMN_NAME_REGISTRATION + " TEXT, " +
            TripTableEntry.COLUMN_NAME_MAKE + " TEXT, " + TripTableEntry.COLUMN_NAME_MODEL + " TEXT, " + TripTableEntry.COLUMN_NAME_YEAR + " DATE, " + TripTableEntry.COLUMN_NAME_ENGINE + "TEXT, CONSTRAINT " +
            TripTableEntry.CONSTRAINT_NAME_LOGBOOK + " FOREIGN KEY (" + TripTableEntry.COLUMN_NAME_LOGBOOK + ") REFERENCES " + LogTable.LogTableEntry.TABLE_NAME + " (" + LogTable.LogTableEntry._ID + "))";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TripTableEntry.TABLE_NAME;
}