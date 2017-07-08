package com.ibm.jp.icw.model;

public class Brand {

	private String brandCode;
	private String brandName;
	private String market;
	private String industry;
	private int tradingUnit;
	private String brandStatus;
	private double marketPrice;
	private double openingPrice;
	private double closePrice;
	private double highPrice;
	private double lowPrice;
	private double offerPrice;
	private double bidPrice;
	private double yearToDateHighs;
	private double yearToDateLows;

	public Brand(String brandCode, String brandName, int marketPrice){
		this.brandCode = brandCode;
		this.brandName = brandName;
		this.marketPrice = marketPrice;
	}

	public Brand(String brandCode, String brandName, String market, String industry, int tradingUnit, String brandStatus,
			double marketPrice){
		this.brandCode = brandCode;
		this.brandName = brandName;
		this.market = market;
		this.industry = industry;
		this.tradingUnit = tradingUnit;
		this.brandStatus = brandStatus;
		this.marketPrice = marketPrice;
	}

	public Brand(String brandCode, String brandName, String market, String industry, int tradingUnit, String brandStatus,
			double marketPrice, double openingPrice, double closePrice, double highPrice, double lowPrice, double offerPrice, double bidPrice,
			double yearToDateHighs, double yearToDateLows) {
		super();
		this.brandCode = brandCode;
		this.brandName = brandName;
		this.market = market;
		this.industry = industry;
		this.tradingUnit = tradingUnit;
		this.brandStatus = brandStatus;
		this.marketPrice = marketPrice;
		this.openingPrice = openingPrice;
		this.closePrice = closePrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.offerPrice = offerPrice;
		this.bidPrice = bidPrice;
		this.yearToDateHighs = yearToDateHighs;
		this.yearToDateLows = yearToDateLows;
	}

	public String getBrandCode() {
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

	public String getBrandStatus(){
		return brandStatus;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public double getOpeningPrice() {
		return openingPrice;
	}

	public double getClosePrice() {
		return closePrice;
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
