package com.bank.service;

import com.bank.account.BankAccount;
import com.bank.exception.InsufficientFundsException;

public class TransactionService {

    private static TransactionService instance;

    private TransactionService() {}

    public static synchronized TransactionService getInstance() {
        if (instance == null) {
            instance = new TransactionService();
        }
        return instance;
    }

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(BankAccount account, double amount) throws InsufficientFundsException {
        account.withdraw(amount);
    }
}
