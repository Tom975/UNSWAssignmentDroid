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
            " (" + DriverTableEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + DriverTableEntry.COLUMN_NAME_NAME + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DriverTable.DriverTableEntry.TABLE_NAME;


    /**
     * SQL compatible string for returning all drivers
     */
    public static final String SQL_SELECT_ALL = "SELECT * FROM " + DriverTableEntry.TABLE_NAME;

    /**
     * Returns an SQL compatible string for getting the details row of a Driver using the name of driver
     * @param name the name of the driver being searched for
     * @return an SQL compatible string for finding a driver
     */
    public static String selectDriver(String name) {
        String SQL_Select = "SELECT * FROM " + DriverTableEntry.TABLE_NAME + " WHERE " + DriverTableEntry.COLUMN_NAME_NAME + " = \"" + name + "\"";
        return SQL_Select;
    }

    /**
     * Returns an SQL compatible string for getting the details row of a Driver using the id of driver
     * @param id the name of the driver being searched for
     * @return an SQL compatible string for finding a driver
     */
    public static String selectDriver(int id) {
        String SQL_Select = "SELECT * FROM " + DriverTableEntry.TABLE_NAME + " WHERE " + DriverTableEntry._ID+ " = " + id;
        return SQL_Select;
    }

    /**
     * Returns an SQL compatible string for inserting a new row in the Driver table
     * @param name The name of the new Driver
     * @return an SQL compatible string for inserting a driver
     */
    public static String insertDriver(String name) {
        String SQL_Insert = "INSERT INTO " + DriverTableEntry.TABLE_NAME + " VALUES (NULL, " + name + ")";
        return SQL_Insert;
    }

    /**
     * Returns an SQL compatible string for delete a row using the name of a driver
     * @param name The name of the driver to be deleted
     * @return an SQL compatible string for deleting a driver
     */
    public static String deleteDriver(String name) {
        String SQL_Delete = "DELETE FROM " + DriverTableEntry.TABLE_NAME + " WHERE " + DriverTableEntry.COLUMN_NAME_NAME + " = \"" + name + "\"";
        return SQL_Delete;
    }

    /**
     * Returns an SQL compatible string for delete a row using the id of a driver
     * @param id The name of the driver to be deleted
     * @return an SQL compatible string for deleting a driver
     */
    public static String deleteDriver(int id) {
        String SQL_Delete = "DELETE FROM " + DriverTableEntry.TABLE_NAME + " WHERE " + DriverTableEntry._ID + " = " + id;
        return SQL_Delete;
    }
}