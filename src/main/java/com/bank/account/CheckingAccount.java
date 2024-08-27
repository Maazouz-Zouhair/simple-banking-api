package com.bank.account;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}
