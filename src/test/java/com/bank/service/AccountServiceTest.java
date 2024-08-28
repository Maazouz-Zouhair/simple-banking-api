package com.bank.service;

import com.bank.account.BankAccount;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.InvalidAccountTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = AccountService.getInstance();
    }

    @Test
    void createAccount_ValidType() throws InvalidAccountTypeException, AccountNotFoundException {
        accountService.createAccount("savings", "123456");
        BankAccount account = accountService.getAccount("123456");
        assertNotNull(account);
        assertEquals("123456", account.getAccountNumber());
    }

    @Test
    void createAccount_InvalidType() {
        Exception exception = assertThrows(InvalidAccountTypeException.class, () -> accountService.createAccount("invalidType", "123456"));
        assertEquals("Unknown account type: invalidType", exception.getMessage());
    }

    @Test
    void getAccount_ValidAccountNumber() throws InvalidAccountTypeException, AccountNotFoundException {
        accountService.createAccount("savings", "123456");
        BankAccount account = accountService.getAccount("123456");
        assertNotNull(account);
        assertEquals("123456", account.getAccountNumber());
    }

    @Test
    void getAccount_InvalidAccountNumber() {
        Exception exception = assertThrows(AccountNotFoundException.class, () -> accountService.getAccount("999999"));
        assertEquals("Account not found: 999999", exception.getMessage());
    }

}
