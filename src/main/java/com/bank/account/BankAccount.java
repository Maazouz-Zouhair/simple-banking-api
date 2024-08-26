package com.bank.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bank.exception.InsufficientFundsException;

public class BankAccount {
    private String accountNumber;
	private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(new Date(), amount, "Deposit"));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
        transactions.add(new Transaction(new Date(), -amount, "Withdrawal"));
    }

    public double getBalance() {
        return balance;
    }

    public AccountStatement getStatement() {
        return new AccountStatement(transactions);
    }
    
    public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
