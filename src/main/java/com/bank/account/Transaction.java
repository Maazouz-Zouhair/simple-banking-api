package com.bank.account;

import java.util.Date;

/**
 * Transaction represents a financial transaction on a bank account. It records
 * the date, type, amount, and balance after the transaction.
 */
public class Transaction {
	private Date date;
	private double amount;
	private double balance;
	private String type;

	public Transaction(String type, double amount, double balance) {
		this.date = new Date(); // Initialize with the current date and time
		this.amount = amount;
		this.balance = balance;
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public double getBalance() {
		return balance;
	}

	public String getType() {
		return type;
	}
}
