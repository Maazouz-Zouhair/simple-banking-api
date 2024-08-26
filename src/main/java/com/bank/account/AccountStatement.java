package com.bank.account;

import java.util.List;

public class AccountStatement {
    private List<Transaction> transactions;

    public AccountStatement(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void printStatement() {
        System.out.println("Date\t\tAmount\tType");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDate() + "\t" + transaction.getAmount() + "\t" + transaction.getType());
        }
    }
}
