package com.example.z5056635.assignment.Databases;

import android.provider.BaseColumns;

import java.util.Date;

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
            " (" + ExpenseTable.ExpenseTableEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + VehicleTableEntry.COLUMN_NAME_REGISTRATION + " TEXT," +
            VehicleTableEntry.COLUMN_NAME_MAKE + " TEXT," + VehicleTableEntry.COLUMN_NAME_MODEL + " TEXT," +
            VehicleTableEntry.COLUMN_NAME_YEAR + " DATE," + VehicleTableEntry.COLUMN_NAME_ENGINE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + VehicleTableEntry.TABLE_NAME;

    /**
     * SQL compatible string for returning all rows of the Vehicle Table
     */
    public static final String SQL_SELECT_ALL = "SELECT * FROM " + VehicleTableEntry.TABLE_NAME;

    /**
     * Returns an SQL compatible string that can be used to select a row from the Vehicle table using its id
     *
     * @param id the primary key of the row to be selected
     * @return an SQL compatible string that selects a row based on its primary key
     */
    public static String selectVehicle(int id) {
        String SQL_Select = "SELECT * FROM " + VehicleTableEntry.TABLE_NAME + " WHERE " + VehicleTableEntry._ID + " = " + id;
        return SQL_Select;
    }

    /**
     * Returns an SQL compatible string that can be used to delete a row from the Vehicle table using its id
     *
     * @param id the primary key of the row to be deleted
     * @return an SQL compatible string that deletes a row based on its primary key
     */
    public static String deleteVehicle(int id) {
        String SQL_Delete = "DELETE FROM " + VehicleTableEntry.TABLE_NAME + " WHERE " + VehicleTableEntry._ID + " = " + id;
        return SQL_Delete;
    }

    /**
     * Returns an SQL compatible string that can be used to insert a row into the vehicle table
     * @param registrationNumber    the registration number of the vehicle
     * @param make                  the make of the vehicle
     * @param model                 the model of the vehicle
     * @param year                  the year of the vehicle
     * @param engine                the engine size of the vehicle
     * @return                      the SQL compatible string
     */
    public static String insertVehicle(String registrationNumber, String make, String model, Date year, String engine) {
        String SQL_Insert = "INSERT INTO " + VehicleTableEntry.TABLE_NAME + " VALUES (NULL, " + registrationNumber + "\", \"" + make + "\", \"" + model + "\", " + year + ", \"" + engine + "\")";
        return SQL_Insert;
    }
}