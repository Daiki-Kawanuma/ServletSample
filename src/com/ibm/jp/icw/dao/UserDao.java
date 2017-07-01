package com.ibm.jp.icw.dao;

import com.ibm.jp.icw.model.User;

public class UserDao extends BaseDao {

	
	public User getUser(String accountNumber) {
		return new User();
	}
}
