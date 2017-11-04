package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by z5056635 on 18/10/2017.
 */

public class TripTable {
    private TripTable() {}

    public static class TripTableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Trips";
        public static final String COLUMN_NAME_LOGBOOK = "Log_Book";
        public static final String COLUMN_NAME_STARTODO = "Start_Odometer";
        public static final String COLUMN_NAME_ENDODO = "End_Odometer";
        public static final String COLUMN_NAME_STARTDATE = "Start_Date";
        public static final String COLUMN_NAME_ENDDATE = "End_Date";
        public static final String COLUMN_NAME_REASON = "Name";
        public static final String COLUMN_NAME_WORK = "Work";
        public static final String CONSTRAINT_NAME_LOGBOOK = "fk_logbook";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TripTableEntry.TABLE_NAME +
            " (" + TripTableEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + TripTableEntry.COLUMN_NAME_LOGBOOK + " INTEGER, " + TripTableEntry.COLUMN_NAME_STARTODO + " INTEGER, " +
            TripTableEntry.COLUMN_NAME_ENDODO + " INTEGER, " + TripTableEntry.COLUMN_NAME_STARTDATE + " DATE, " + TripTableEntry.COLUMN_NAME_ENDDATE + " DATE, " + TripTableEntry.COLUMN_NAME_REASON + " TEXT, " +  TripTableEntry.COLUMN_NAME_WORK + " BOOLEAN, CONSTRAINT " +
            TripTableEntry.CONSTRAINT_NAME_LOGBOOK + " FOREIGN KEY (" + TripTableEntry.COLUMN_NAME_LOGBOOK + ") REFERENCES " + LogTable.LogTableEntry.TABLE_NAME + " (" + LogTable.LogTableEntry._ID + "))";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TripTableEntry.TABLE_NAME;

    /**
     * SQL compatible string for returning all rows of the Trip Table
     */
    public static final String SQL_SELECT_ALL = "SELECT * FROM " + TripTableEntry.TABLE_NAME;

    /**
     * Returns an SQL compatible string that can be used to select a row from the Trip table using its id
     *
     * @param id the primary key of the row to be selected
     * @return an SQL compatible string that selects a row based on its primary key
     */
    public static String selectTrip(int id) {
        String SQL_Select = "SELECT * FROM " + TripTableEntry.TABLE_NAME + " WHERE " + TripTableEntry._ID + " = " + id;
        return SQL_Select;
    }

    /**
     * Returns an SQL compatible string that can be used to delete a row from the Trip table using its id
     *
     * @param id the primary key of the row to be deleted
     * @return an SQL compatible string that deletes a row based on its primary key
     */
    public static String deleteTrip(int id) {
        String SQL_Delete = "DELETE FROM " + TripTableEntry.TABLE_NAME + " WHERE " + TripTableEntry._ID + " = " + id;
        return SQL_Delete;
    }

    public static String insertTrip(int logBookID, int startOdo, int endOdo, Date startDate, Date endDate, String reason, Boolean work) {
        String SQL_Insert = "INSERT INTO " + TripTableEntry.TABLE_NAME + " VALUES (NULL, " + logBookID + ", " + startOdo + ", " + endOdo+ ", " + startDate+ ", " + endDate+ ", \"" + reason + "\", " + work + ")";
        return SQL_Insert;
    }
}