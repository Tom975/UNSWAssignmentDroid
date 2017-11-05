package com.example.z5056635.assignment.Objects;

import com.example.z5056635.assignment.Databases.LogTable;

import java.util.Date;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class Log {
    private int rowID;
    private Date periodStart;
    private Date periodEnd;
    private int driverID;
    private int vehicleID;

    public Log(Date periodStart, Date periodEnd, int driverID, int vehicleID) {
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.driverID = driverID;
        this.vehicleID = vehicleID;
    }

    public Log(int rowID, Date periodStart, Date periodEnd, int driverID, int vehicleID) {
        this.rowID = rowID;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.driverID = driverID;
        this.vehicleID = vehicleID;
    }

    public Log(Date periodStart, Date periodEnd) {
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public Log(Date periodStart) {
        this.periodStart = periodStart;
    }

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String printSummary() {
        return null;
    }
}
