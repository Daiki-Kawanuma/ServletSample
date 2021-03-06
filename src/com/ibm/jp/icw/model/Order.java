package com.ibm.jp.icw.model;

import java.util.Date;

public class Order {

	public enum OrderType{
		成行("成行"),
		指値("指値"),
		指成("指成");

		private String name;
        public String getName() {
            return name;
        }
        private OrderType (String name) {
          this.name = name;
        }
        public String toString() {
          return name;
        }

        public static OrderType getEnum(String str) {
        	OrderType[] enumArray = OrderType.values();

            for(OrderType enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())){
                    return enumStr;
                }
            }
            return null;
        }
	}

	public enum OrderCondition{

		無条件("無条件"),
		寄付("寄付"),
		引け("引け"),
		指成("指成");

		private String name;
        public String getName() {
            return name;
        }
        private OrderCondition (String name) {
          this.name = name;
        }
        public String toString() {
          return name;
        }

        public static OrderCondition getEnum(String str) {
        	OrderCondition[] enumArray = OrderCondition.values();

            for(OrderCondition enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())){
                    return enumStr;
                }
            }
            return null;
        }
	}

	public enum OrderStatus{
		注文中("注文中"),
		成約済み("成約済"),
		不成立("不成立");

		private String name;
        public String getName() {
            return name;
        }
        private OrderStatus (String name) {
          this.name = name;
        }
        public String toString() {
          return name;
        }

        public static OrderStatus getEnum(String str) {
        	OrderStatus[] enumArray = OrderStatus.values();

            for(OrderStatus enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())){
                    return enumStr;
                }
            }
            return null;
        }
	}

	private long receptionNumber;
	private Brand brand;
	private User user;
	private String tradingType;
	private OrderType orderType;
	private OrderCondition orderCondition;
	private int orderAmount;
	private int closingAmount;
	private double orderUnitPrice;
	private double closingUnitPrice;
	private Date orderDate;
	private Date closingDate;
	private OrderStatus orderStatus;

	public Order(Brand brand, User user, String tradingType, OrderType orderType,OrderCondition orderCondition,
			int orderAmount, int orderUnitPrice, Date orderDate){
		this.brand = brand;
		this.user = user;
		this.tradingType = tradingType;
		this.orderType = orderType;
		this.orderCondition = orderCondition;
		this.orderAmount = orderAmount;
		this.orderUnitPrice = orderUnitPrice;
		this.orderDate = orderDate;
	}

	public Order(long receptionNumber, Brand brand, User user, String tradingType, OrderType orderType,
			OrderCondition orderCondition, int orderAmount,int closingAmount, double orderUnitPrice,
			double closingUnitPrice, Date orderDate, Date closingDate, OrderStatus orderStatus) {
		super();
		this.receptionNumber = receptionNumber;
		this.brand = brand;
		this.user = user;
		this.tradingType = tradingType;
		this.orderType = orderType;
		this.orderCondition = orderCondition;
		this.orderAmount = orderAmount;
		this.closingAmount = closingAmount;
		this.orderUnitPrice = orderUnitPrice;
		this.closingUnitPrice = closingUnitPrice;
		this.orderDate = orderDate;
		this.closingDate = closingDate;
		this.orderStatus = orderStatus;
	}

	public void setReceptionNumber(long receptionNumber){
		this.receptionNumber = receptionNumber;
	}

	public long getReceptionNumber() {
		return receptionNumber;
	}

	public Brand getBrand() {
		return brand;
	}

	public User getUser() {
		return user;
	}

	public String getTradingType(){
		return tradingType;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public OrderCondition getOrderConditions() {
		return orderCondition;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public int getClosingAmount() {
		return closingAmount;
	}

	public double getOrderUnitPrice() {
		return orderUnitPrice;
	}

	public double getClosingUnitPrice() {
		return closingUnitPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	@Override
	public String toString(){
		return "受付番号:" + receptionNumber
		+ ", 銘柄: " + brand
		+ ", ユーザー: " + user
		+ ", 売買区分: " + tradingType
		+ ", 注文の種類: " + orderType
		+ ", 注文状況: " + orderCondition
		+ ", 注文数: " + orderAmount
		+ ", 成約数: " + closingAmount
		+ ", 注文単価: " + orderUnitPrice
		+ ", 成約単価: " + closingUnitPrice
		+ ", 注文日: " + orderDate
		+ ", 成約日: " + closingDate
		+ ", 銘柄状態: " +  orderStatus;
	}

}
