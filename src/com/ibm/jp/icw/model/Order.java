package com.ibm.jp.icw.model;

import java.util.Date;

public class Order {

	public enum OrderKind{
		orderWithoutLimit,
		orderWithLimit
	}

	public enum OrderConditions{
		unconditional,
		donation,
		shrinkage,
		specify
	}

	public enum OrderStatus{

	}


	public Order(int receptionNumber, Brand brand, User user, OrderKind orderKind,
			OrderConditions orderConditions, int orderAmount, double orderUnitPrice,
			double closingUnitPrice, Date orderDate, Date closingDate, OrderStatus orderStatus) {
		super();
		this.receptionNumber = receptionNumber;
		this.brand = brand;
		this.user = user;
		this.orderKind = orderKind;
		this.orderConditions = orderConditions;
		this.orderAmount = orderAmount;
		this.orderUnitPrice = orderUnitPrice;
		this.closingUnitPrice = closingUnitPrice;
		this.orderDate = orderDate;
		this.closingDate = closingDate;
		this.orderStatus = orderStatus;
	}

	private int receptionNumber;
	private Brand brand;
	private User user;
	private OrderKind orderKind;
	private OrderConditions orderConditions;
	private int orderAmount;
	private double orderUnitPrice;
	private double closingUnitPrice;
	private Date orderDate;
	private Date closingDate;
	private OrderStatus orderStatus;

	public int getReceptionNumber() {
		return receptionNumber;
	}

	public Brand getBrand() {
		return brand;
	}

	public User getUser() {
		return user;
	}

	public OrderKind getOrderKind() {
		return orderKind;
	}

	public OrderConditions getOrderConditions() {
		return orderConditions;
	}

	public int getOrderAmount() {
		return orderAmount;
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
}
