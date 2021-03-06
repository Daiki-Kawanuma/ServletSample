package com.ibm.jp.icw.model;

import java.util.Date;

public class User {

	private String accountNumber;
	private String name;
	private String password;
	private String mail;
	private Date birthday;
	private int accountBalance;
	private String creditCardNumber;
	private String creditCardName;
	private String creditCardSecurityCode;
	private Date creditCardValidatedDate;

	public User(String accoutNumber){
		this.accountNumber = accoutNumber;
	}

	public User(String accountNumber, String name, String password, String mail, Date birthday, int accountBalance, String creditCardNumber, String creditCardName,
			String creditCardSecurityCode, Date creditCardValidatedDate) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.birthday = birthday;
		this.accountBalance = accountBalance;
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

	public String getMail() {
		return mail;
	}

	public Date getBirthday() {
		return birthday;
	}

	public int getAccountBalance() {
		return accountBalance;
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

	@Override
	public String toString(){
		return "口座番号:" + accountNumber
		+ ", 名前: " + name
		+ ", パスワード: " + password
		+ ", メール: " + mail
		+ ", 誕生日: " + birthday
		+ ", 口座残高: " + accountBalance
		+ ", クレジットカード番号: " + creditCardNumber
		+ ", クレジットカード名義: " + creditCardName
		+ ", クレジットカード暗証番号: " + creditCardSecurityCode
		+ ", クレジットカード有効期限: " + creditCardValidatedDate;
	}

}
