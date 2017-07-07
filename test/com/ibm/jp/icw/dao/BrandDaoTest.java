package com.ibm.jp.icw.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jp.icw.dao.util.UtilDAO;
import com.ibm.jp.icw.model.User;

public class BrandDaoTest {

	UtilDAO utilDao = new UtilDAO();
	String accountNumber;

	@Before
	public void setUp() throws Exception {
		utilDao.init();
	}

	@After
	public void tearDown() throws Exception {
		utilDao.close();
	}

	@Test
	public void ユーザーのデータがない場合は取得結果はNUll() {
		accountNumber = "1000";
		User user = UserDao.getUser(accountNumber);
		assertNull(user);
	}

	@Test
	public void ユーザーのデータがある場合は取得結果はNotNull() {
		accountNumber = "1000000000000001";
		User user = UserDao.getUser(accountNumber);
		assertNotNull(user);
	}
}