package com.ibm.jp.icw.model;

import java.util.Date;

public class MarketPrice {

	private String brandCode;
	private Date date;
	private double price;

	public MarketPrice(String brandCode, Date date, double price) {
		super();
		this.brandCode = brandCode;
		this.date = date;
		this.price = price;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public Date getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}
}
