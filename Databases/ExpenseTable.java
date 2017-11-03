package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by z5056635 on 11/10/2017.
 */

public final class ExpenseTable {
    private ExpenseTable() {
    }

    public static class ExpenseTableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Expenses";
        public static final String COLUMN_NAME_LOGBOOK = "Log_Book";
        public static final String COLUMN_NAME_DATE = "Date";
        public static final String COLUMN_NAME_COST = "Cost";
        public static final String COLUMN_NAME_REASON = "Reason";
        public static final String COLUMN_NAME_WORK = "Work";
        public static final String COLUMN_NAME_RECEIPT = "Receipt_Location";
        public static final String CONSTRAINT_NAME_DRIVER = "fk_driver";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ExpenseTableEntry.TABLE_NAME +
            " (" + ExpenseTableEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + ExpenseTableEntry.COLUMN_NAME_LOGBOOK + "INTEGER, " + ExpenseTableEntry.COLUMN_NAME_DATE + " DATE," +
            ExpenseTableEntry.COLUMN_NAME_COST + " DECIMAL(10,2)," + ExpenseTableEntry.COLUMN_NAME_REASON + " TEXT," +
            ExpenseTableEntry.COLUMN_NAME_WORK + " BOOLEAN," + ExpenseTableEntry.COLUMN_NAME_RECEIPT + " TEXT, CONSTRAINT " + ExpenseTableEntry.CONSTRAINT_NAME_DRIVER + " FOREIGN KEY (" +
            ExpenseTableEntry.COLUMN_NAME_LOGBOOK + ") REFERENCES " + DriverTable.DriverTableEntry.TABLE_NAME + " (" + DriverTable.DriverTableEntry._ID + "))";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ExpenseTableEntry.TABLE_NAME;

    /**
     * SQL compatible string for returning all rows of the Expense Table
     */
    public static final String SQL_SELECT_ALL = "SELECT * FROM " + ExpenseTableEntry.TABLE_NAME;

    /**
     * Returns an SQL compatible string that can be used to Insert a new item into the Expense table
     * @param logBookID the ID number of the relevant log book to be stored in
     * @param date      the date the expense occured
     * @param cost      the cost of the expense as a decimal
     * @param reason    the reason for the expense
     * @param work      boolean value, true meaning work related, false meaning not work related
     * @param location  storage location of receipt photos
     * @return          The SQL compatible string that inserts a new row
     */
    public static String insertExpense(int logBookID, Date date, double cost, String reason, Boolean work, String location) {
        String SQL_Insert = "INSERT INTO " + ExpenseTableEntry.TABLE_NAME + " VALUES (NULL, " + logBookID + ", " + date.toString() + ", " + cost + ", \"" + reason + "\", " + work + ", \"" + location + "\")";
        return SQL_Insert;
    }

    /**
     * Returns an SQL compatible string that can be used to select a row from the Expense table using its id
     *
     * @param id the primary key of the row to be selected
     * @return an SQL compatible string that selects a row based on its primary key
     */
    public static String selectExpense(int id) {
        String SQL_Select = "SELECT * FROM " + ExpenseTableEntry.TABLE_NAME + " WHERE " + ExpenseTableEntry._ID + " = " + id;
        return SQL_Select;
    }

    /**
     * Returns an SQL compatible string that can be used to delete a row from the Expense table using its id
     *
     * @param id the primary key of the row to be deleted
     * @return an SQL compatible string that deletes a row based on its primary key
     */
    public static String deleteExpense(int id) {
        String SQL_Delete = "DELETE FROM " + ExpenseTableEntry.TABLE_NAME + " WHERE " + ExpenseTableEntry._ID + " = " + id;
        return SQL_Delete;
    }
}