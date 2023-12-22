package com.practice.chin.ds;

public class TransactionException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage;
	String errorCode;
	public TransactionException(String errorMessage, String errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public String getErrorCode() {
		return errorCode;
	}

}
