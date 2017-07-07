package com.ibm.jp.icw.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jp.icw.dao.util.UtilDAO;
import com.ibm.jp.icw.model.User;

public class UserDaoTest {

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
    public void 正しい口座番号が入力された場合は取得結果は() {
        accountNumber = "1000000000000001";
        User user = UserDao.getUser(accountNumber);
        assertNull(user);
    }

	@Test
    public void 間違った口座番号が入力された場合は取得結果はNUll() {
        accountNumber = "0000000000000000";
        User user = UserDao.getUser(accountNumber);
        assertNull(user);
    }

	@Test
    public void 異常値が入力された場合は取得結果はNUll() {
        accountNumber = "99999999999999999";
        User user = UserDao.getUser(accountNumber);
        assertNull(user);
    }

	@Test
    public void NULLが入力された場合は取得結果はNUll() {
        accountNumber = null;
        User user = UserDao.getUser(accountNumber);
        assertNull(user);
    }
}
