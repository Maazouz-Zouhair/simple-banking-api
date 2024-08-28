package com.bank;

import java.util.Scanner;

import com.bank.account.AccountStatement;
import com.bank.account.BankAccount;
import com.bank.account.ConsoleStatementPrinter;
import com.bank.account.StatementPrinter;
import com.bank.exception.InsufficientFundsException;
import com.bank.exception.InvalidAccountTypeException;
import com.bank.exception.InvalidTransactionAmountException;
import com.bank.factory.AccountFactory;
import com.bank.service.TransactionService;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TransactionService transactionService = new TransactionService();

		// Create a SavingsAccount using the factory
		BankAccount account;
		try {
			account = AccountFactory.createAccount("savings", "123456");

			System.out.println("Welcome to the Interactive Banking System!");
			boolean exit = false;

			while (!exit) {
				System.out.println("\nPlease choose an option:");
				System.out.println("1. Make a Deposit");
				System.out.println("2. Make a Withdrawal");
				System.out.println("3. View Transaction History");
				System.out.println("4. Exit");

				String choice = scanner.nextLine();

				switch (choice) {
				case "1":
					System.out.print("Enter the amount to deposit: ");
					double depositAmount = Double.parseDouble(scanner.nextLine());
					try {
						transactionService.deposit(account, depositAmount);
						System.out.println("Deposit successful!");
					} catch (InvalidTransactionAmountException e) {
						System.out.println("Error: " + e.getMessage());

					}
					break;

				case "2":
					System.out.print("Enter the amount to withdraw: ");
					double withdrawAmount = Double.parseDouble(scanner.nextLine());
					try {
						transactionService.withdraw(account, withdrawAmount);
						System.out.println("Withdrawal successful!");
					} catch (InvalidTransactionAmountException | InsufficientFundsException e) {
						System.out.println("Error: " + e.getMessage());
					}
					break;

				case "3":
					printStatement(account);
					break;

				case "4":
					exit = true;
					System.out.println("Thank you for using the Interactive Banking System!");
					break;

				default:
					System.out.println("Invalid option. Please try again.");
					break;
				}
			}

		} catch (InvalidAccountTypeException e) {
			System.out.println("Error: " + e.getMessage());
		}

		scanner.close();
	}

	private static void printStatement(BankAccount account) {
		System.out.println("Transaction History:");
		StatementPrinter printer = new StatementPrinter(new ConsoleStatementPrinter());
		printer.print(new AccountStatement(account.getTransactions()));
	}
}
