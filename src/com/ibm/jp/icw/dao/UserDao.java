package com.ibm.jp.icw.dao;

import com.ibm.jp.icw.model.User;

public class UserDao extends AbstDao {

	public User getUser(String userid) {
		return new User();
	}
}
