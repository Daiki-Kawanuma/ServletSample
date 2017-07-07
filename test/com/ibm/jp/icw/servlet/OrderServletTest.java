package com.ibm.jp.icw.servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class OrderServletTest {

	@Test
	public void testValidateInputs() {
		// 事前準備
		OrderServlet servlet = new OrderServlet();
		String orderType;
		String orderCondition;
		String orderAmount;
		String orderUnitPrice;
		boolean result;

		// ユースケース１のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}
}
