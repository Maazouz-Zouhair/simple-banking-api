package com.bank.account;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
