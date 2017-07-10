package com.ibm.jp.icw.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jp.icw.dao.util.UtilDAO;
import com.ibm.jp.icw.model.Brand;
import com.ibm.jp.icw.model.Order;
import com.ibm.jp.icw.model.User;

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
	public void 口座番号1000000000000001を入力すると過去の注文全てが取得される() {
		accountNumber = "1000000000000001";
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

	@Test
	public void 口座番号1000000000000001銘柄コード1332で注文を登録する() {

		User user = new User("1000000000000001");
		Brand brand = new Brand("1332", "日本水産", "正常銘柄", 682);

		Order order = new Order(brand, user, "B", Order.OrderType.getEnum("成行"),
				Order.OrderCondition.getEnum("無条件"),
				Integer.parseInt("999"), Integer.parseInt("999"), new Date());

		order = OrderDao.registOrder(order);

		assertThat((int)order.getReceptionNumber(), not(-1));
	}

	@Test
	public void 口座番号99999999999999999銘柄コード99999で注文を登録する() {

		User user = new User("99999999999999999");
		Brand brand = new Brand("99999", "日本水産", "正常銘柄", 682);

		Order order = new Order(brand, user, "B", Order.OrderType.getEnum("成行"),
				Order.OrderCondition.getEnum("無条件"),
				Integer.parseInt("100"), Integer.parseInt("100"), new Date());

		order = OrderDao.registOrder(order);

		assertThat((int)order.getReceptionNumber(), is(-1));
	}

	@Test
	public void 口座番号0000000000000000銘柄コード0000で注文を登録する() {

		User user = new User("0000000000000000");
		Brand brand = new Brand("0000", "日本水産", "正常銘柄", 682);

		Order order = new Order(brand, user, "B", Order.OrderType.getEnum("成行"),
				Order.OrderCondition.getEnum("無条件"),
				Integer.parseInt("100"), Integer.parseInt("100"), new Date());

		order = OrderDao.registOrder(order);

		assertThat((int)order.getReceptionNumber(), is(-1));
	}
}
