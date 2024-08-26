package com.bank.account;

import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private String type;

    public Transaction(Date date, double amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
