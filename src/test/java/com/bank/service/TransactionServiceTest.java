package com.bank.service;

import com.bank.account.BankAccount;
import com.bank.account.SavingsAccount;
import com.bank.exception.InsufficientFundsException;
import com.bank.exception.InvalidTransactionAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private TransactionService transactionService;
    private BankAccount account;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService();
        account = new SavingsAccount("123456");
    }

    @Test
    void deposit_ValidAmount() throws InvalidTransactionAmountException {
        transactionService.deposit(account, 200);
        assertEquals(200, account.getBalance());
    }

    @Test
    void deposit_InvalidAmount() {
        Exception exception = assertThrows(InvalidTransactionAmountException.class, () -> transactionService.deposit(account, -100));
        assertEquals("Amount must be positive.", exception.getMessage());
    }

    @Test
    void withdraw_ValidAmount() throws InvalidTransactionAmountException, InsufficientFundsException {
        transactionService.deposit(account, 200);
        transactionService.withdraw(account, 100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void withdraw_InvalidAmount() {
        Exception exception = assertThrows(InvalidTransactionAmountException.class, () -> transactionService.withdraw(account, -100));
        assertEquals("Amount must be positive.", exception.getMessage());
    }

    @Test
    void withdraw_InsufficientFunds() throws InvalidTransactionAmountException {
        transactionService.deposit(account, 100);
        Exception exception = assertThrows(InsufficientFundsException.class, () -> transactionService.withdraw(account, 200));
        assertEquals("Insufficient funds for withdrawal", exception.getMessage());
    }
}
