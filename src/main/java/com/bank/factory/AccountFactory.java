package com.bank.factory;

import com.bank.account.BankAccount;
import com.bank.account.SavingsAccount;
import com.bank.exception.InvalidAccountTypeException;

public class AccountFactory {

    /**
     * Factory method to create different types of bank accounts.
     * This method is thread-safe, and future extensions can easily be added.
     *
     * @param type          The type of account to create (e.g., "savings", "checking").
     * @param accountNumber The account number for the new account.
     * @return A new instance of a BankAccount subclass based on the specified type.
     * @throws InvalidAccountTypeException 
     * @throws IllegalArgumentException if the account type is not recognized.
     */
    public static BankAccount createAccount(String type, String accountNumber) throws InvalidAccountTypeException {
    	if ("savings".equalsIgnoreCase(type)) {
            return new SavingsAccount(accountNumber);
        } else {
            throw new InvalidAccountTypeException("Unknown account type: " + type);
        }
    }
}
