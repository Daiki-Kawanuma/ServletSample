package com.ibm.jp.icw.model;

import java.util.Date;

public class User {

	private String id;
	private String name;
	private Date birthDay;
	private String address;
	public String getId() {
		return id;
	}

	public static User getUser(String id){
		return new User();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
