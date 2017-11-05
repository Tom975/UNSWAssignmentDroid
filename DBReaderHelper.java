package com.example.z5056635.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.z5056635.assignment.Databases.DriverTable;
import com.example.z5056635.assignment.Databases.ExpenseTable;
import com.example.z5056635.assignment.Databases.LogTable;
import com.example.z5056635.assignment.Databases.TripTable;
import com.example.z5056635.assignment.Databases.VehicleTable;
import com.example.z5056635.assignment.Objects.Driver;
import com.example.z5056635.assignment.Objects.Expense;
import com.example.z5056635.assignment.Objects.Log;
import com.example.z5056635.assignment.Objects.Trip;
import com.example.z5056635.assignment.Objects.Vehicle;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class DBReaderHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LogBook.db";

    public DBReaderHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DriverTable.SQL_CREATE_ENTRIES);
        db.execSQL(ExpenseTable.SQL_CREATE_ENTRIES);
        db.execSQL(LogTable.SQL_CREATE_ENTRIES);
        db.execSQL(TripTable.SQL_CREATE_ENTRIES);
        db.execSQL(VehicleTable.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DriverTable.SQL_DELETE_ENTRIES);
        db.execSQL(ExpenseTable.SQL_DELETE_ENTRIES);
        db.execSQL(LogTable.SQL_DELETE_ENTRIES);
        db.execSQL(TripTable.SQL_DELETE_ENTRIES);
        db.execSQL(VehicleTable.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onOpen(SQLiteDatabase db) {
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    //Driver Functions
    public void addDriver(Driver driver) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DriverTable.DriverTableEntry.COLUMN_NAME_NAME, driver.getName());

        db.insert(DriverTable.DriverTableEntry.TABLE_NAME, null, values);
        db.close();
    }

    public Driver getDriver(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DriverTable.DriverTableEntry.TABLE_NAME,
                new String[] {DriverTable.DriverTableEntry._ID,
                        DriverTable.DriverTableEntry.COLUMN_NAME_NAME},
                DriverTable.DriverTableEntry._ID + "=?", new String[] {String.valueOf(id)},
                null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        Driver driver = new Driver(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        return driver;
    }

    public List<Driver> getAllDrivers() {
        List<Driver> driverList = new ArrayList<Driver>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DriverTable.SQL_SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do {
                Driver driver = new Driver(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
                driverList.add(driver);
            } while (cursor.moveToNext());
        }

        return driverList;
    }

    public int getDriversCount() {
        String countQuery = "SELECT * FROM " + DriverTable.DriverTableEntry.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateDriver(Driver driver) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DriverTable.DriverTableEntry.COLUMN_NAME_NAME, driver.getName());

        return db.update(DriverTable.DriverTableEntry.TABLE_NAME, values,
                DriverTable.DriverTableEntry._ID + " = ?", new String[] {String.valueOf(driver.getRowID())});
    }

    public void deleteDriver(Driver driver) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DriverTable.DriverTableEntry.TABLE_NAME, DriverTable.DriverTableEntry._ID + " = ?",
                new String[] {String.valueOf(driver.getRowID())});
        db.close();
    }

    // Vehicle Functions
    public void addVehicle(Vehicle vehicle) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_REGISTRATION, vehicle.getRegistration());
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_MAKE, vehicle.getMake());
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_MODEL, vehicle.getModel());
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_YEAR, vehicle.getYear().toString());
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_ENGINE, vehicle.getEngine());

        db.insert(VehicleTable.VehicleTableEntry.TABLE_NAME, null, values);
        db.close();
    }

    public Vehicle getVehicle(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(VehicleTable.VehicleTableEntry.TABLE_NAME,
                new String[] {VehicleTable.VehicleTableEntry._ID,
                        VehicleTable.VehicleTableEntry.COLUMN_NAME_REGISTRATION,
                        VehicleTable.VehicleTableEntry.COLUMN_NAME_MAKE,
                        VehicleTable.VehicleTableEntry.COLUMN_NAME_MODEL,
                        VehicleTable.VehicleTableEntry.COLUMN_NAME_YEAR,
                        VehicleTable.VehicleTableEntry.COLUMN_NAME_ENGINE},
                VehicleTable.VehicleTableEntry._ID + "=?", new String[] {String.valueOf(id)},
                null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        Vehicle vehicle = new Vehicle(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                new Date(cursor.getString(4)),
                cursor.getString(5));
        return vehicle;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(VehicleTable.SQL_SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do {
                Vehicle vehicle = new Vehicle(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        new Date(cursor.getString(4)),
                        cursor.getString(5));
                vehicleList.add(vehicle);
            } while (cursor.moveToNext());
        }

        return vehicleList;
    }

    public int getVehiclesCount() {
        String countQuery = "SELECT * FROM " + VehicleTable.VehicleTableEntry.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateVehicle(Vehicle vehicle) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_REGISTRATION, vehicle.getRegistration());
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_MAKE, vehicle.getMake());
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_MODEL, vehicle.getModel());
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_YEAR, vehicle.getYear().toString());
        values.put(VehicleTable.VehicleTableEntry.COLUMN_NAME_ENGINE, vehicle.getEngine());

        return db.update(VehicleTable.VehicleTableEntry.TABLE_NAME, values,
                VehicleTable.VehicleTableEntry._ID + " = ?", new String[] {String.valueOf(vehicle.getRowID())});
    }

    public void deleteVehicle(Vehicle vehicle) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VehicleTable.VehicleTableEntry.TABLE_NAME, VehicleTable.VehicleTableEntry._ID + " = ?",
                new String[] {String.valueOf(vehicle.getRowID())});
        db.close();
    }

    // Log Functions
    public void addLog(Log log) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LogTable.LogTableEntry.COLUMN_NAME_VEHICLE, log.getVehicleID());
        values.put(LogTable.LogTableEntry.COLUMN_NAME_DRIVER, log.getDriverID());
        values.put(LogTable.LogTableEntry.COLUMN_NAME_START_DATE, log.getPeriodStart().toString());
        values.put(LogTable.LogTableEntry.COLUMN_NAME_END_DATE, log.getPeriodEnd().toString());

        db.insert(LogTable.LogTableEntry.TABLE_NAME, null, values);
        db.close();
    }

    public Log getLog(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(LogTable.LogTableEntry.TABLE_NAME,
                new String[] {LogTable.LogTableEntry._ID,
                        LogTable.LogTableEntry.COLUMN_NAME_VEHICLE,
                        LogTable.LogTableEntry.COLUMN_NAME_DRIVER,
                        LogTable.LogTableEntry.COLUMN_NAME_START_DATE,
                        LogTable.LogTableEntry.COLUMN_NAME_END_DATE},
                LogTable.LogTableEntry._ID + "=?", new String[] {String.valueOf(id)},
                null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        Log log = new Log(Integer.parseInt(cursor.getString(0)),
                new Date(cursor.getString(3)),
                new Date(cursor.getString(4)),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)));
        return log;
    }

    public List<Log> getAllLogs() {
        List<Log> logList = new ArrayList<Log>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(LogTable.SQL_SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do {
                Log log = new Log(Integer.parseInt(cursor.getString(0)),
                        new Date(cursor.getString(3)),
                        new Date(cursor.getString(4)),
                        Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2)));

                logList.add(log);
            } while (cursor.moveToNext());
        }

        return logList;
    }

    public int getLogsCount() {
        String countQuery = "SELECT * FROM " + LogTable.LogTableEntry.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateLog(Log log) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LogTable.LogTableEntry.COLUMN_NAME_VEHICLE, log.getVehicleID());
        values.put(LogTable.LogTableEntry.COLUMN_NAME_DRIVER, log.getDriverID());
        values.put(LogTable.LogTableEntry.COLUMN_NAME_START_DATE, log.getPeriodStart().toString());
        values.put(LogTable.LogTableEntry.COLUMN_NAME_END_DATE, log.getPeriodEnd().toString());

        return db.update(LogTable.LogTableEntry.TABLE_NAME, values,
                LogTable.LogTableEntry._ID + " = ?", new String[] {String.valueOf(log.getRowID())});
    }

    public void deleteLog(Log log) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LogTable.LogTableEntry.TABLE_NAME, LogTable.LogTableEntry._ID + " = ?",
                new String[] {String.valueOf(log.getRowID())});
        db.close();
    }

    // Trip Functions
    public void addTrip(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TripTable.TripTableEntry.COLUMN_NAME_LOGBOOK, trip.getLogID());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_STARTODO, trip.getOdoStart());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_ENDODO, trip.getOdoEnd());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_STARTDATE, trip.getDateStart().toString());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_ENDDATE, trip.getDateEnd().toString());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_REASON, trip.getName());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_WORK, trip.isWork());

        db.insert(TripTable.TripTableEntry.TABLE_NAME, null, values);
        db.close();
    }

    public Trip getTrip(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TripTable.TripTableEntry.TABLE_NAME,
                new String[] {TripTable.TripTableEntry._ID,
                        TripTable.TripTableEntry.COLUMN_NAME_LOGBOOK,
                        TripTable.TripTableEntry.COLUMN_NAME_STARTODO,
                        TripTable.TripTableEntry.COLUMN_NAME_ENDODO,
                        TripTable.TripTableEntry.COLUMN_NAME_STARTDATE,
                        TripTable.TripTableEntry.COLUMN_NAME_ENDDATE,
                        TripTable.TripTableEntry.COLUMN_NAME_REASON,
                        TripTable.TripTableEntry.COLUMN_NAME_WORK},
                TripTable.TripTableEntry._ID + "=?", new String[] {String.valueOf(id)},
                null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        Trip trip = new Trip(cursor.getInt(0),
                cursor.getInt(2),
                cursor.getInt(3),
                new Date(cursor.getString(4)),
                new Date(cursor.getString(5)),
                cursor.getString(6),
                Boolean.parseBoolean(cursor.getString(7)),
                cursor.getInt(1));
        return trip;
    }

    public List<Trip> getAllTrips() {
        List<Trip> tripList = new ArrayList<Trip>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(TripTable.SQL_SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do {
                Trip trip = new Trip(cursor.getInt(0),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        new Date(cursor.getString(4)),
                        new Date(cursor.getString(5)),
                        cursor.getString(6),
                        Boolean.parseBoolean(cursor.getString(7)),
                        cursor.getInt(1));

                tripList.add(trip);
            } while (cursor.moveToNext());
        }

        return tripList;
    }

    public int getTripsCount() {
        String countQuery = "SELECT * FROM " + TripTable.TripTableEntry.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateTrip(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TripTable.TripTableEntry.COLUMN_NAME_LOGBOOK, trip.getLogID());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_STARTODO, trip.getOdoStart());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_ENDODO, trip.getOdoEnd());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_STARTDATE, trip.getDateStart().toString());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_ENDDATE, trip.getDateEnd().toString());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_REASON, trip.getName());
        values.put(TripTable.TripTableEntry.COLUMN_NAME_WORK, trip.isWork());

        return db.update(TripTable.TripTableEntry.TABLE_NAME, values,
                TripTable.TripTableEntry._ID + " = ?", new String[] {String.valueOf(trip.getRowID())});
    }

    public void deleteTrip(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TripTable.TripTableEntry.TABLE_NAME, TripTable.TripTableEntry._ID + " = ?",
                new String[] {String.valueOf(trip.getRowID())});
        db.close();
    }

    // Expense Functions
    public void addExpense(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_LOGBOOK, expense.getLogID());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_DATE, expense.getDate().toString());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_COST, expense.getCost());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_REASON, expense.getReason());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_WORK, expense.isWork());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_RECEIPT, expense.getReceipt().toString());

        db.insert(ExpenseTable.ExpenseTableEntry.TABLE_NAME, null, values);
        db.close();
    }

    public Expense getExpense(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ExpenseTable.ExpenseTableEntry.TABLE_NAME,
                new String[] {ExpenseTable.ExpenseTableEntry._ID,
                        ExpenseTable.ExpenseTableEntry.COLUMN_NAME_LOGBOOK,
                        ExpenseTable.ExpenseTableEntry.COLUMN_NAME_DATE,
                        ExpenseTable.ExpenseTableEntry.COLUMN_NAME_COST,
                        ExpenseTable.ExpenseTableEntry.COLUMN_NAME_REASON,
                        ExpenseTable.ExpenseTableEntry.COLUMN_NAME_WORK},
                ExpenseTable.ExpenseTableEntry._ID + "=?", new String[] {String.valueOf(id)},
                null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        Expense expense = new Expense(cursor.getInt(0),
                new Date(cursor.getString(2)),
                cursor.getDouble(3),
                cursor.getString(4),
                Boolean.parseBoolean(cursor.getString(5)),
                new File(cursor.getString(6)),
                cursor.getInt(1));
        return expense;
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenseList = new ArrayList<Expense>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(ExpenseTable.SQL_SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do {
                Expense expense = new Expense(cursor.getInt(0),
                        new Date(cursor.getString(2)),
                        cursor.getDouble(3),
                        cursor.getString(4),
                        Boolean.parseBoolean(cursor.getString(5)),
                        new File(cursor.getString(6)),
                        cursor.getInt(1));
                expenseList.add(expense);
            } while (cursor.moveToNext());
        }

        return expenseList;
    }

    public int getExpensesCount() {
        String countQuery = "SELECT * FROM " + ExpenseTable.ExpenseTableEntry.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateExpense(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_LOGBOOK, expense.getLogID());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_DATE, expense.getDate().toString());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_COST, expense.getCost());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_REASON, expense.getReason());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_WORK, expense.isWork());
        values.put(ExpenseTable.ExpenseTableEntry.COLUMN_NAME_RECEIPT, expense.getReceipt().toString());

        return db.update(ExpenseTable.ExpenseTableEntry.TABLE_NAME, values,
                ExpenseTable.ExpenseTableEntry._ID + " = ?", new String[] {String.valueOf(expense.getRowID())});
    }

    public void deleteExpense(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ExpenseTable.ExpenseTableEntry.TABLE_NAME, ExpenseTable.ExpenseTableEntry._ID + " = ?",
                new String[] {String.valueOf(expense.getRowID())});
        db.close();
    }
}