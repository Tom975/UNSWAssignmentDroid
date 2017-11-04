package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

import java.util.Date;

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

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + LogTableEntry.TABLE_NAME + " (" + LogTableEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LogTableEntry.COLUMN_NAME_VEHICLE + " INTEGER, " +
            LogTableEntry.COLUMN_NAME_DRIVER + " INTEGER, " + LogTableEntry.COLUMN_NAME_START_DATE + " DATE, " + LogTableEntry.COLUMN_NAME_END_DATE + " DATE, CONSTRAINT " + LogTableEntry.CONSTRAINT_NAME_VEHICLE +
            " FOREIGN KEY (" + LogTableEntry.COLUMN_NAME_VEHICLE + ") REFERENCES " + VehicleTable.VehicleTableEntry.TABLE_NAME + " (" + VehicleTable.VehicleTableEntry._ID + "), CONSTRAINT " +
            LogTableEntry.CONSTRAINT_NAME_DRIVER + " FOREIGN KEY (" + LogTableEntry.COLUMN_NAME_DRIVER + ") REFERENCES " + DriverTable.DriverTableEntry.TABLE_NAME + " (" + DriverTable.DriverTableEntry._ID + "))";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + LogTableEntry.TABLE_NAME;

    /**
     * SQL compatible string for returning all rows of the Log Table
     */
    public static final String SQL_SELECT_ALL = "SELECT * FROM " + LogTableEntry.TABLE_NAME;

    /**
     * Returns an SQL compatible string that can be used to select a row from the Log table using its id
     *
     * @param id the primary key of the row to be selected
     * @return an SQL compatible string that selects a row based on its primary key
     */
    public static String selectLog(int id) {
        String SQL_Select = "SELECT * FROM " + LogTableEntry.TABLE_NAME + " WHERE " + LogTableEntry._ID + " = " + id;
        return SQL_Select;
    }

    /**
     * Returns an SQL compatible string that can be used to delete a row from the Log table using its id
     *
     * @param id the primary key of the row to be deleted
     * @return an SQL compatible string that deletes a row based on its primary key
     */
    public static String deleteLog(int id) {
        String SQL_Delete = "DELETE FROM " + LogTableEntry.TABLE_NAME + " WHERE " + LogTableEntry._ID + " = " + id;
        return SQL_Delete;
    }

    /**
     * Returns an SQL compatible string that can be used to insert a row into the Log table
     * @param vehicleID foreign key for the vehicle the log book is associated with
     * @param driverID  foreign key for the driver the log book is associated with
     * @param startDate start date of the log book
     * @param endDate   end date of the log book
     * @return          the SQL compatible string
     */
    public static String insertLog(int vehicleID, int driverID, Date startDate, Date endDate) {
        String SQL_Insert = "INSERT INTO " + LogTableEntry.TABLE_NAME + " VALUES (NULL, " + vehicleID + ", " + driverID + ", " + startDate.toString() + ", " + endDate.toString() + ")";
        return SQL_Insert;
    }
}