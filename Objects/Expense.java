package com.example.z5056635.assignment.Objects;

import com.example.z5056635.assignment.Databases.ExpenseTable;

import java.io.File;
import java.util.Date;

/**
 * Created by z5056635 on 11/10/2017.
 */

public class Expense {
    private int rowID;
    private Date date;
    private double cost;
    private String reason;
    private boolean work;
    private File receipt;
    private Log log;

    public Expense(Date date, double cost, String reason, boolean work, File receipt, Log log) {
        this.date = date;
        this.cost = cost;
        this.reason = reason;
        this.work = work;
        this.receipt = receipt;
        this.log = log;
    }

    public static String toSQLInsert(Expense expense) {
        return ExpenseTable.insertExpense(expense.getLog().getRowID(), expense.getDate(), expense.getCost(), expense.getReason(), expense.isWork(), expense.getReceipt().toString());
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

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
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
