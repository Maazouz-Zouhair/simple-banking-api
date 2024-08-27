package com.bank.account;

public class StatementPrinter {

    private StatementPrinterStrategy strategy;

    public StatementPrinter(StatementPrinterStrategy strategy) {
        this.strategy = strategy;
    }

    public void print(AccountStatement statement) {
        strategy.print(statement);
    }

    public void setStrategy(StatementPrinterStrategy strategy) {
        this.strategy = strategy;
    }
}