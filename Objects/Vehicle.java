package com.example.z5056635.assignment.Objects;

import com.example.z5056635.assignment.Databases.VehicleTable;

import java.util.Date;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class Vehicle {
    private int rowID;
    private String registration;
    private String make;
    private String model;
    private Date year;
    private String engine;

    public Vehicle(String registration, String make, String model, Date year, String engine) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public static String toSQLInsert(Vehicle vehicle) {
        return VehicleTable.insertVehicle(vehicle.getRegistration(), vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getEngine());
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}