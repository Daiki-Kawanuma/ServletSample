package com.ibm.jp.icw.model;

public class Brand {

	private int brandCode;
	private String brandName;
	private double fiarPrice;
	private double openingPrice;
	private double highPrice;
	private double lowPrice;
	private double offerPrice;
	private double bidPrice;
	private double yearToDateHighs;
	private double yearToDateLows;

	public Brand(int brandCode, String brandName, double fiarPrice, double openingPrice, double highPrice,
			double lowPrice, double offerPrice, double bidPrice, double yearToDateHighs, double yearToDateLows) {
		super();
		this.brandCode = brandCode;
		this.brandName = brandName;
		this.fiarPrice = fiarPrice;
		this.openingPrice = openingPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.offerPrice = offerPrice;
		this.bidPrice = bidPrice;
		this.yearToDateHighs = yearToDateHighs;
		this.yearToDateLows = yearToDateLows;
	}

	public int getBrandCode() {
		return brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public double getFiarPrice() {
		return fiarPrice;
	}

	public double getOpeningPrice() {
		return openingPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public double getOfferPrice() {
		return offerPrice;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public double getYearToDateHighs() {
		return yearToDateHighs;
	}

	public double getYearToDateLows() {
		return yearToDateLows;
	}
}
