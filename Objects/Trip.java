package com.example.z5056635.assignment.Objects;

import com.example.z5056635.assignment.Databases.TripTable;

import java.util.Date;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class Trip {
    private int rowID;
    private int odoStart;
    private int odoEnd;
    private Date dateStart;
    private Date dateEnd;
    private String name;
    private boolean work;
    private int logID;

    public Trip(int odoStart, int odoEnd, Date dateStart, Date dateEnd, String name, boolean work, int logID) {
        this.odoStart = odoStart;
        this.odoEnd = odoEnd;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.name = name;
        this.work = work;
        this.logID = logID;
    }

    public Trip(int rowID, int odoStart, int odoEnd, Date dateStart, Date dateEnd, String name, boolean work, int logID) {
        this.rowID = rowID;
        this.odoStart = odoStart;
        this.odoEnd = odoEnd;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.name = name;
        this.work = work;

        this.logID = logID;
    }

    public String printReport() {
        return null;
    }

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public int getOdoStart() {
        return odoStart;
    }

    public void setOdoStart(int odoStart) {
        this.odoStart = odoStart;
    }

    public int getOdoEnd() {
        return odoEnd;
    }

    public void setOdoEnd(int odoEnd) {
        this.odoEnd = odoEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }
}
