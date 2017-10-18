package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

/**
 * Created by z5056635 on 11/10/2017.
 */

public final class ExpenseTable {
    private ExpenseTable() {}

    public static class ExpenseTableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Expenses";
        public static final String COLUMN_NAME_DATE = "Date";
        public static final String COLUMN_NAME_COST = "Cost";
        public static final String COLUMN_NAME_REASON = "Reason";
        public static final String COLUMN_NAME_WORK = "Work";
        public static final String COLUMN_NAME_RECEIPT = "Receipt Location";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ExpenseTableEntry.TABLE_NAME +
            " (" + ExpenseTableEntry._ID + "INTEGER PRIMARY KEY," + ExpenseTableEntry.COLUMN_NAME_DATE + " DATE," +
            ExpenseTableEntry.COLUMN_NAME_COST + " DECIMAL(10,2)," + ExpenseTableEntry.COLUMN_NAME_REASON + " TEXT," +
            ExpenseTableEntry.COLUMN_NAME_WORK + " BOOLEAN," + ExpenseTableEntry.COLUMN_NAME_RECEIPT + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ExpenseTableEntry.TABLE_NAME;
}