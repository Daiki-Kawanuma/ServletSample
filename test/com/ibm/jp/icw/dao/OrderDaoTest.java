package com.ibm.jp.icw.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jp.icw.dao.util.UtilDAO;
import com.ibm.jp.icw.model.Order;

public class OrderDaoTest {

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
	public void 口座番号1000000000000000を入力すると過去の注文全てが取得される() {
		accountNumber = "1000000000000000";
		ArrayList<Order> list = OrderDao.getOrderList(accountNumber);
		assertThat(list.size(), not(0));
	}

	@Test
	public void 口座番号0000000000000000を入力するとsize0が返される() {
		accountNumber = "0000000000000000";
		ArrayList<Order> list = OrderDao.getOrderList(accountNumber);
		assertThat(list.size(), is(0));
	}

	@Test
	public void 口座番号9999999999999を入力するとsize0が返される() {
		accountNumber = "99999999999999999";
		ArrayList<Order> list = OrderDao.getOrderList(accountNumber);
		assertThat(list.size(), is(0));
	}

	@Test
	public void 口座番号を空欄にするとsize0が返される() {
		accountNumber = "";
		ArrayList<Order> list = OrderDao.getOrderList(accountNumber);
		assertThat(list.size(), is(0));
	}

	//川沼がやれ
	// 登録の話
	@Test
	public void 注文を登録する() {
	}
}


