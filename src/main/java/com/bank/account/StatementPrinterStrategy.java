package com.bank.account;

/**
 * StatementPrinterStrategy is an interface for printing account statements.
 * Implementations can define how the statement is printed.
 */
public interface StatementPrinterStrategy {
	void print(AccountStatement statement);
}
