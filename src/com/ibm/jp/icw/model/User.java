package com.ibm.jp.icw.model;

import java.util.Date;

public class User {

	private int accountNumber;
	private String name;
	private int creditCardNumber;
	private String nameOfCreditCard;
	private int creditCardSecurityCode;
	private Date creditCardValidatedDate;

	public User(int accountNumber, String name, int creditCardNumber, String nameOfCreditCard,
			int creditCardSecurityCode, Date creditCardValidatedDate) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.creditCardNumber = creditCardNumber;
		this.nameOfCreditCard = nameOfCreditCard;
		this.creditCardSecurityCode = creditCardSecurityCode;
		this.creditCardValidatedDate = creditCardValidatedDate;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public String getNameOfCreditCard() {
		return nameOfCreditCard;
	}

	public int getCreditCardSecurityCode() {
		return creditCardSecurityCode;
	}

	public Date getCreditCardValidatedDate() {
		return creditCardValidatedDate;
	}
}
