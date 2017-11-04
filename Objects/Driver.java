package com.example.z5056635.assignment.Objects;

import com.example.z5056635.assignment.Databases.DriverTable;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class Driver {

    private int rowID;
    private String Name;

    public Driver(String name) {
        Name = name;
    }

    public static String toSQLInsert(Driver driver) {
        return DriverTable.insertDriver(driver.getName());
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }
}
