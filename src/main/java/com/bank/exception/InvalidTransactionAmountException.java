package com.bank.exception;

public class InvalidTransactionAmountException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7219787104512064273L;

	public InvalidTransactionAmountException(String message) {
        super(message);
    }
}
