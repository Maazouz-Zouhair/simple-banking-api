package com.bank.factory;

import com.bank.account.BankAccount;
import com.bank.account.CheckingAccount;
import com.bank.account.SavingsAccount;

public class AccountFactory {

    /**
     * Factory method to create different types of bank accounts.
     * This method is thread-safe, and future extensions can easily be added.
     *
     * @param type          The type of account to create (e.g., "savings", "checking").
     * @param accountNumber The account number for the new account.
     * @return A new instance of a BankAccount subclass based on the specified type.
     * @throws IllegalArgumentException if the account type is not recognized.
     */
    public static BankAccount createAccount(String type, String accountNumber) {
        switch (type.toLowerCase()) {
            case "savings":
                return new SavingsAccount(accountNumber);
            case "checking":
                return new CheckingAccount(accountNumber);
            default:
                throw new IllegalArgumentException("Unknown account type: " + type);
        }
    }
}
