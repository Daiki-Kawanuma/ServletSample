package com.ibm.jp.icw.model;

public class Stock {

	private int number;
	private String companyName;
	private double price;
	private double previousDayClosingPrice;
	private double openingPrice;
	private double highPrice;
	private double lowPrice;
	private int yield;
	private int buyingAndSellingPrice;
	private double dailyLimit;

	public static Stock getStock(int number){
		return new Stock();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPreviousDayClosingPrice() {
		return previousDayClosingPrice;
	}

	public void setPreviousDayClosingPrice(double previousDayClosingPrice) {
		this.previousDayClosingPrice = previousDayClosingPrice;
	}

	public double getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public int getYield() {
		return yield;
	}

	public void setYield(int yield) {
		this.yield = yield;
	}

	public int getBuyingAndSellingPrice() {
		return buyingAndSellingPrice;
	}

	public void setBuyingAndSellingPrice(int buyingAndSellingPrice) {
		this.buyingAndSellingPrice = buyingAndSellingPrice;
	}

	public double getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(double dailyLimit) {
		this.dailyLimit = dailyLimit;
	}
}
