package com.example.z5056635.assignment.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class Log {
    private Date periodStart;
    private Date periodEnd;
    private List<Trip> trips;
    private List<Expense> expenses;

    public Log(Date periodStart, Date periodEnd) {
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;

        trips = new ArrayList<Trip>();
        expenses = new ArrayList<Expense>();
    }

    public Log(Date periodStart) {
        this.periodStart = periodStart;

        trips = new ArrayList<Trip>();
        expenses = new ArrayList<Expense>();
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

    public String printSummary() {
        return null;
    }

    public void newTrip() {

    }

    public void modifyTrip() {

    }

    public void newExpense() {

    }

    public static void saveToDB(Log log) {

    }

    public static Log loadFromDB(int key) {

    }
}
