package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

/**
 * Created by z5056635 on 18/10/2017.
 */

public class DriverTable {
    private DriverTable() {}

    public static class DriverTableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Drivers";
        public static final String COLUMN_NAME_NAME = "Name";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + DriverTable.DriverTableEntry.TABLE_NAME +
            " (" + DriverTableEntry._ID + "INTEGER PRIMARY KEY," + DriverTableEntry.COLUMN_NAME_NAME + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DriverTable.DriverTableEntry.TABLE_NAME;
}