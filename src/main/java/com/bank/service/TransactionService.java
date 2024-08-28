package com.bank.service;

import com.bank.account.BankAccount;
import com.bank.exception.InsufficientFundsException;
import com.bank.exception.InvalidTransactionAmountException;

/**
 * TransactionService handles deposit and withdrawal operations on bank
 * accounts.
 */
public class TransactionService {

	public void deposit(BankAccount account, double amount) throws InvalidTransactionAmountException {
		if (amount <= 0) {
			throw new InvalidTransactionAmountException("Amount must be positive.");
		}
		account.deposit(amount);
		logTransaction(account, amount, "Deposit");
	}

	public void withdraw(BankAccount account, double amount)
			throws InvalidTransactionAmountException, InsufficientFundsException {
		if (amount <= 0) {
			throw new InvalidTransactionAmountException("Amount must be positive.");
		}
		if (account.getBalance() < amount) {
			throw new InsufficientFundsException("Insufficient funds for withdrawal");
		}
		account.withdraw(amount);
		logTransaction(account, amount, "Withdrawal");
	}

	private void logTransaction(BankAccount account, double amount, String transactionType) {
		System.out.println(
				transactionType + " of amount " + amount + " completed on account " + account.getAccountNumber());
	}
}
