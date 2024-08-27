package com.bank.account;

import com.bank.utils.DateUtils;

public class ConsoleStatementPrinter implements StatementPrinterStrategy {

    @Override
    public void print(AccountStatement statement) {
        System.out.println("Account Statement:");
        System.out.println("Date\t\t\tAmount\tBalance\tType");
        for (Transaction transaction : statement.getTransactions()) {
            String formattedDate = DateUtils.formatDate(transaction.getDate());
            System.out.println(formattedDate + "\t" + transaction.getAmount() + "\t" + transaction.getBalance() + "\t" + transaction.getType());
        }
    }
}
