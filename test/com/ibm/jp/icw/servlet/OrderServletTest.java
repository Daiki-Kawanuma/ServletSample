package com.ibm.jp.icw.servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class OrderServletTest {

	OrderServlet servlet = new OrderServlet();
	String orderType;
	String orderCondition;
	String orderAmount;
	String orderUnitPrice;
	boolean result;

	@Test
	public void 成行ー無条件ー100ー100でTRUEを返す() {

		// ユーザの入力
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 成行ー寄付ー100ー100でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "寄付";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}
}
