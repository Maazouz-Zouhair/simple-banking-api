package com.bank.account;

import com.bank.utils.DateUtils;

/**
 * ConsoleStatementPrinter is a concrete implementation of
 * StatementPrinterStrategy that prints the account statement to the console.
 */
public class ConsoleStatementPrinter implements StatementPrinterStrategy {

	@Override
	public void print(AccountStatement statement) {
		System.out.println("Account Statement:");
		System.out.println("Date\t\t\tAmount\tBalance\tType");
		for (Transaction transaction : statement.getTransactions()) {
			System.out.println(DateUtils.formatDate(transaction.getDate()) + "\t" + transaction.getAmount() + "\t"
					+ transaction.getBalance() + "\t" + transaction.getType());
		}
	}

}
