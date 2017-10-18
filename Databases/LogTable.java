package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

/**
 * Created by z5056635 on 18/10/2017.
 */

public class LogTable {
    private LogTable() {}

    public static class LogTableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Logs";
        public static final String COLUMN_NAME_START_DATE = "Start Date";
        public static final String COLUMN_NAME_END_DATE = "End Date";
        // TODO: 18/10/2017 connect to trips and expenses
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + LogTableEntry.TABLE_NAME +
            " (" + LogTableEntry._ID + "INTEGER PRIMARY KEY," + LogTableEntry.COLUMN_NAME_START_DATE + " DATE," +
            LogTableEntry.COLUMN_NAME_END_DATE + " DATE)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + LogTableEntry.TABLE_NAME;
}