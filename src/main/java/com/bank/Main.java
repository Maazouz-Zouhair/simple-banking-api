package com.bank;

import com.bank.account.BankAccount;
import com.bank.account.ConsoleStatementPrinter;
import com.bank.account.AccountStatement;
import com.bank.account.StatementPrinter;
import com.bank.exception.InsufficientFundsException;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456");

        account.deposit(1000);
        try {
            account.withdraw(200);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        AccountStatement statement = account.getStatement();
        StatementPrinter printer = new StatementPrinter(new ConsoleStatementPrinter());
        printer.print(statement);
    }
}
