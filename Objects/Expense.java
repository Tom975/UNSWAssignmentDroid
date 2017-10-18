package com.example.z5056635.assignment.Objects;

import java.io.File;
import java.util.Date;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class Expense {
    private Date date;
    private double cost;
    private String reason;
    private boolean work;
    private File receipt;

    public Expense(Date date, double cost, String reason, boolean work) {
        this.date = date;
        this.cost = cost;
        this.reason = reason;
        this.work = work;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public File getReceipt() {
        return receipt;
    }

    public void setReceipt(File receipt) {
        this.receipt = receipt;
    }

    public String printReport() {
        return null;
    }
}
