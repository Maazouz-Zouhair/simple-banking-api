package com.bank.account;

import com.bank.exception.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount("123456");
    }

    @Test
    void deposit() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
        assertEquals(1, account.getTransactions().size());
    }

    @Test
    void withdraw() throws InsufficientFundsException {
        account.deposit(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
        assertEquals(2, account.getTransactions().size());
    }

    @Test
    void withdraw_InsufficientFunds() {
        account.deposit(100);
        Exception exception = assertThrows(InsufficientFundsException.class, () -> account.withdraw(150));
        assertEquals("Insufficient funds for withdrawal", exception.getMessage());
    }
    
    @Test
    void getAccountType() {
        assertEquals("Savings", account.getAccountType());
    }
}
