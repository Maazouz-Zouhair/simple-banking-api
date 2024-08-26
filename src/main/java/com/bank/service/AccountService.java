package com.bank.service;

import com.bank.account.BankAccount;
import com.bank.exception.AccountNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private static AccountService instance;
    private Map<String, BankAccount> accounts;

    private AccountService() {
        accounts = new HashMap<>();
    }

    public static synchronized AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }

    public void createAccount(String accountNumber) {
        accounts.put(accountNumber, new BankAccount(accountNumber));
    }

    public BankAccount getAccount(String accountNumber) throws AccountNotFoundException {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        return account;
    }
}
