package com.bank;

import com.bank.account.BankAccount;
import com.bank.account.ConsoleStatementPrinter;
import com.bank.account.AccountStatement;
import com.bank.account.StatementPrinter;
import com.bank.exception.InsufficientFundsException;
import com.bank.factory.AccountFactory;

public class Main {
	public static void main(String[] args) {

		// Create a bank account using the factory method
		BankAccount account = AccountFactory.createAccount("savings", "123456");

		account.deposit(1000);
		try {
			account.withdraw(200);
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}

		// Create an AccountStatement object with all transactions
		AccountStatement statement = new AccountStatement(account.getTransactions());

		// Print the statement using the Strategy pattern with ConsoleStatementPrinter
		StatementPrinter printer = new StatementPrinter(new ConsoleStatementPrinter());
		printer.print(statement);

	}
}
