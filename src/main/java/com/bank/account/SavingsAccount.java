package com.bank.account;

/**
 * SavingsAccount is a concrete subclass of BankAccount representing a savings
 * account.
 */
public class SavingsAccount extends BankAccount {
	public SavingsAccount(String accountNumber) {
		super(accountNumber);
	}

	@Override
	public String getAccountType() {
		return "Savings";
	}
}
