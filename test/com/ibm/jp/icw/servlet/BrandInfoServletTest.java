package com.ibm.jp.icw.servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BrandInfoServletTest {

	BrandInfoServlet servlet = new BrandInfoServlet();
	String searchType;
	String searchCondition;
	boolean result;

	@Test
	public void 銘柄コードー1332でTRUEを返す() {

		// ユーザの入力
		searchType = "brandcode";
		searchCondition = "1332";
		// 実行
		result = servlet.validateInputs(searchType, searchCondition);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 銘柄コードー123でFALSEを返す() {

		// ユーザの入力
		searchType = "brandcode";
		searchCondition = "123";
		// 実行
		result = servlet.validateInputs(searchType, searchCondition);
		// 検証
		assertThat(result, is(false));
	}
	@Test
	public void 銘柄コードーaaaaでFALSEを返す() {

		// ユーザの入力
		searchType = "brandcode";
		searchCondition = "aaaa";
		// 実行
		result = servlet.validateInputs(searchType, searchCondition);
		// 検証
		assertThat(result, is(false));
	}
	@Test
	public void 銘柄名ー空白でFALSEを返す() {

		// ユーザの入力
		searchType = "brandname";
		searchCondition = "";
		// 実行
		result = servlet.validateInputs(searchType, searchCondition);
		// 検証
		assertThat(result, is(false));
	}
	@Test
	public void 銘柄名ー日本水産でTRUEを返す() {

		// ユーザの入力
		searchType = "brandname";
		searchCondition = "日本水産";
		// 実行
		result = servlet.validateInputs(searchType, searchCondition);
		// 検証
		assertThat(result, is(true));
	}
	@Test
	public void 銘柄コードー空白でFALSEを返す() {

		// ユーザの入力
		searchType = "brandcode";
		searchCondition = "";
		// 実行
		result = servlet.validateInputs(searchType, searchCondition);
		// 検証
		assertThat(result, is(false));
	}
	@Test
	public void nullー1332でFALSEを返す() {

		// ユーザの入力
		searchType = "null";
		searchCondition = "1332";
		// 実行
		result = servlet.validateInputs(searchType, searchCondition);
		// 検証
		assertThat(result, is(false));
	}
	@Test
	public void 銘柄コードーnullでFALSEを返す() {

		// ユーザの入力
		searchType = "brandcode";
		searchCondition = "null";
		// 実行
		result = servlet.validateInputs(searchType, searchCondition);
		// 検証
		assertThat(result, is(false));
	}
}
