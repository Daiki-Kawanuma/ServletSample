package com.ibm.jp.icw.model;

import java.util.Date;

public class FairPrice {

	private int brandCode;
	private Date date;
	private double price;

	public FairPrice(int brandCode, Date date, double price) {
		super();
		this.brandCode = brandCode;
		this.date = date;
		this.price = price;
	}

	public int getBrandCode() {
		return brandCode;
	}

	public Date getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}
}
