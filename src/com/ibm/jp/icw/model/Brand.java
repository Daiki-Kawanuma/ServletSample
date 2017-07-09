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

	public Brand(String brandCode, String brandName, String brandStatus, int marketPrice){
		this.brandCode = brandCode;
		this.brandName = brandName;
		this.brandStatus = brandStatus;
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

	@Override
	public String toString(){
		return "銘柄コード:" + brandCode
		+ ", 銘柄名: " + brandName
		+ ", 市場: " + market
		+ ", 業界: " + industry
		+ ", 売買単位: " + tradingUnit
		+ ", 銘柄状況: " + brandStatus
		+ ", 時価: " + marketPrice
		+ ", 始値: " + openingPrice
		+ ", 終値: " + closePrice
		+ ", 高値: " + highPrice
		+ ", 安値: " + lowPrice
		+ ", 売り気配値: " + offerPrice
		+ ", 買い気配値: " +  bidPrice
		+ ", 年初来高値: " + yearToDateHighs
		+ ", 年初来安値: " + yearToDateLows;
	}
}
