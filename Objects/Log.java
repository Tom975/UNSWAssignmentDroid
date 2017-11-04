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
    private Driver driver;
    private Vehicle vehicle;

    public Log(Date periodStart, Driver driver, Vehicle vehicle) {
        this.periodStart = periodStart;
        this.driver = driver;
        this.vehicle = vehicle;
    }

    public Log(Date periodStart, Date periodEnd) {
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public Log(Date periodStart) {
        this.periodStart = periodStart;
    }

    public static String toSQLInsert(Log log) {
        return LogTable.insertLog(log.getVehicle().getRowID(), log.getDriver().getRowID(), log.getPeriodStart(), log.getPeriodEnd());
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String printSummary() {
        return null;
    }
}
