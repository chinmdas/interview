package com.practice.chin.ds;

public class DigitalWalletTransaction {

	public void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
		
		if(digitalWallet.getUserAccessCode()==null || digitalWallet.getUserAccessCode().isEmpty()) {
			throw new TransactionException("Access Code was not found", "USER_NOT_AUTHORIZED");
		}
		if(amount<=0) {
			throw new TransactionException("Adding zero or negative amount", "INVALID_AMOUNT");
		}
		digitalWallet.setWalletBalance(amount);
	}

	public void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
		if(digitalWallet.getUserAccessCode()==null || digitalWallet.getUserAccessCode().isEmpty()) {
			throw new TransactionException("Access Code was not found", "USER_NOT_AUTHORIZED");
		}
		if(amount<=0) {
			throw new TransactionException("Paying zero or negative amount", "INVALID_AMOUNT");
		}
		int balance = digitalWallet.getWalletBalance();
		if(amount>balance) {
			throw new TransactionException("Not enough balance", "INSUFFICIENT_BALANCE");
		}else {
			digitalWallet.setWalletBalance(balance-amount);
		}

	}

}
