package com.bank.account;

import java.util.List;

import com.bank.utils.DateUtils;

public class AccountStatement {
    private List<Transaction> transactions;

    public AccountStatement(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void printStatement() {
        System.out.println("Date\t\t\tAmount\tType");
        for (Transaction transaction : transactions) {
            System.out.println(DateUtils.formatDate(transaction.getDate()) + "\t" + transaction.getAmount() + "\t" + transaction.getType());
        }
    }
}
