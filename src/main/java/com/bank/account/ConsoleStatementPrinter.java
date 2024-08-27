package com.bank.account;

public class ConsoleStatementPrinter implements StatementPrinterStrategy {

	@Override
	public void print(AccountStatement statement) {
		 statement.printStatement();
	}

}
