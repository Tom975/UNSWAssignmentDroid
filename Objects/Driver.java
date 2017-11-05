package com.example.z5056635.assignment.Objects;

import com.example.z5056635.assignment.Databases.DriverTable;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class Driver {

    private int rowID;
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public Driver(int rowID, String name) {
        this.rowID = rowID;
        this.name = name;
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
