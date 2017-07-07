package com.ibm.jp.icw.model;

import java.util.Date;

public class User {

	private String accountNumber;
	private String name;
	private String password;
	private String mail;
	private String birthday;
	private int accountBalance;
	private String creditCardNumber;
	private String creditCardName;
	private String creditCardSecurityCode;
	private Date creditCardValidatedDate;

	public User(String accountNumber, String name, String password, String creditCardNumber, String creditCardName,
			String creditCardSecurityCode, Date creditCardValidatedDate) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.creditCardNumber = creditCardNumber;
		this.creditCardName = creditCardName;
		this.creditCardSecurityCode = creditCardSecurityCode;
		this.creditCardValidatedDate = creditCardValidatedDate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public String getPassword(){
		return password;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public String getCreditCardSecurityCode() {
		return creditCardSecurityCode;
	}

	public Date getCreditCardValidatedDate() {
		return creditCardValidatedDate;
	}
}
