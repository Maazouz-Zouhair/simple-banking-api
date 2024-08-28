package com.bank.account;

import java.util.List;

import com.bank.exception.InsufficientFundsException;

import java.util.ArrayList;

/**
 * BankAccount is an abstract class representing a general bank account.
 * Subclasses like SavingsAccount will provide specific implementations.
 */
public abstract class BankAccount {
	protected String accountNumber;
	protected double balance;
	protected List<Transaction> transactions;

	public BankAccount(String accountNumber) {
		this.accountNumber = accountNumber;
		this.balance = 0.0;
		this.transactions = new ArrayList<>();
	}

	public abstract String getAccountType();

	public void deposit(double amount) {
		balance += amount;
		transactions.add(new Transaction("Deposit", amount, balance));
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if (balance < amount) {
			throw new InsufficientFundsException("Insufficient funds for withdrawal");
		}
		balance -= amount;
		transactions.add(new Transaction("Withdrawal", amount, balance));
	}

	public double getBalance() {
		return balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
}
