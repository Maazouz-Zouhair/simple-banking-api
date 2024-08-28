package com.bank.exception;

public class InsufficientFundsException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3119433432800017122L;

	public InsufficientFundsException(String message) {
        super(message);
    }
}
