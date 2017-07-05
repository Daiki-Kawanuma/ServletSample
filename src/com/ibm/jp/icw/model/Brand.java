package com.ibm.jp.icw.model;

public class Brand {

	private int brandCode;
	private String brandName;
	private String market;
	private String industry;
	private int tradingUnit;
	private double marketPrice;
	private double openingPrice;
	private double highPrice;
	private double lowPrice;
	private double offerPrice;
	private double bidPrice;
	private double yearToDateHighs;
	private double yearToDateLows;

	public Brand(int brandCode, String brandName, String market, String industry, int tradingUnit, double marketPrice,
			double openingPrice, double highPrice, double lowPrice, double offerPrice, double bidPrice,
			double yearToDateHighs, double yearToDateLows) {
		super();
		this.brandCode = brandCode;
		this.brandName = brandName;
		this.market = market;
		this.industry = industry;
		this.tradingUnit = tradingUnit;
		this.marketPrice = marketPrice;
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

	public String getMarket(){
		return market;
	}

	public String getIndustry(){
		return industry;
	}

	public int getTradingUnit(){
		return tradingUnit;
	}

	public double getMarketPrice() {
		return marketPrice;
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
