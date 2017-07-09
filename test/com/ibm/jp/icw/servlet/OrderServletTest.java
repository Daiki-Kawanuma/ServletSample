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
	public void 成行ー無条件ー100ー空文字でTRUEを返す() {

		// ユーザの入力
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 成行ー寄付ー100ー空文字でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "寄付";
		orderAmount = "100";
		orderUnitPrice = "";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 成行ー引けー100ー空文字でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "引け";
		orderAmount = "100";
		orderUnitPrice = "";
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
	public void nullー指成ー100ー100でTRUEを返す() {

		// ユースケース２のパターン
		orderType = null;
		orderCondition = "指成";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 空文字ー指成ー100ー100でTRUEを返す() {

		// ユースケース２のパターン
		orderType = "";
		orderCondition = "指成";
		orderAmount = "100";
		orderUnitPrice = "100";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
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
	public void 成行ー無条件ー100ー空文字でFALSEを返す() {

		// ユースケース２のパターン
		orderType = "成行";
		orderCondition = "無条件";
		orderAmount = "100";
		orderUnitPrice = "";
		// 実行
		result = servlet.validateInputs(orderType, orderCondition, orderAmount, orderUnitPrice);
		// 検証
		assertThat(result, is(true));
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
		assertThat(result, is(true));
	}

	//川沼クレジットカードのテストケースを書け

}
