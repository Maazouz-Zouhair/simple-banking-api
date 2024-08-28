package com.bank.exception;

public class InvalidAccountTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2350965674659077748L;

	public InvalidAccountTypeException(String message) {
        super(message);
    }
}
