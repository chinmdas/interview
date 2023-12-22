package com.practice.chin.ds;

public class DigitalWallet {
	
	String walletId;
	String userName;
	String userAccessCode;
	int walletBalance;
	
	public DigitalWallet(String walletId, String userName) {
		super();
		this.walletId = walletId;
		this.userName = userName;
	}
	
	public DigitalWallet(String walletId, String userName, String userAccessCode) {
		super();
		this.walletId = walletId;
		this.userName = userName;
		this.userAccessCode = userAccessCode;
	}
	
	public String getWalletId() {
		return walletId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserAccessCode() {
		return userAccessCode;
	}
	
	public int getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(int walletBalance) {
		 this.walletBalance=walletBalance;
	}

}
