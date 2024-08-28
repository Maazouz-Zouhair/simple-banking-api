package com.bank.account;

import java.util.Collections;
import java.util.List;

/**
 * AccountStatement is a simple wrapper for a list of transactions.
 * It represents the account statement that can be printed or viewed.
 */
public class AccountStatement {
    private List<Transaction> transactions;

    public AccountStatement(List<Transaction> transactions) {
    	// Make the transactions list immutable
        this.transactions = Collections.unmodifiableList(transactions);
    }

	public List<Transaction> getTransactions() {
		return transactions;
	}
    
}
