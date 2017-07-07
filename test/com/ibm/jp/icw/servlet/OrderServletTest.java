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

	@Test
	public void 成行ー引けー100ー100でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "引け";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 指値ー無条件ー100ー100でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "指値";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 指値ー寄付ー100ー100でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "指値";
		orderCondition = "寄付";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 指値ー引けー100ー100でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "指値";
		orderCondition = "引け";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}
	@Test
	public void 任意ー指成ー100ー100でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "任意";
		orderCondition = "指成";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 成行ー無条件ー99999999ー100でFALSEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "99999999";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(false));
	}

	@Test
	public void 成行ー無条件ーあああー100でFALSEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "あああ";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(false));
	}

	@Test
	public void 成行ー無条件ーnullー100でFALSEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "null";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(false));
	}

	@Test
	public void 成行ー無条件ー100ー99999999でFALSEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "99999999";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(false));
	}

	@Test
	public void 成行ー無条件ー100ーAAAでFALSEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "AAA";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(false));
	}

	@Test
	public void 成行ー無条件ー100ーnullでFALSEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "null";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(false));
	}

	//川沼クレジットカードのテストケースを書け

}
