package com.bank.account;

import java.util.List;

public class AccountStatement {
    private List<Transaction> transactions;

    public AccountStatement(List<Transaction> transactions) {
        this.transactions = transactions;
    }

	public List<Transaction> getTransactions() {
		return transactions;
	}
    
}
