package com.ibm.jp.icw.servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
public class LoginServletTest {

	LoginServlet servlet = new LoginServlet();
	String entryPassword;
	String truePassword;
	boolean result;

	@Test
	public void 入力パスワードー正しいパスワードーthiQKUywーthiQKUywでTRUEを返す() {

		// ユーザの入力
		entryPassword = "thiQKUyw";
		truePassword = "thiQKUyw";
		// 実行
		result = servlet.checkPass(entryPassword, truePassword);
		// 検証
		assertThat(result, is(true));
	}

	@Test
	public void 入力パスワードー正しいパスワードーthiQKUyzーthiQKUywでFAULSEを返す() {

		// ユーザの入力
		String entryPassword = "thiQKUyz";
		String truePassword = "thiQKUyw";
		// 実行
		result = servlet.checkPass(entryPassword, truePassword);
		// 検証
		assertThat(result, is(false));
	}

	@Test
	public void 入力パスワードー正しいパスワードーNULLーthiQKUywでFAULSEを返す() {

		// ユーザの入力
		String entryPassword = null;
		String truePassword = "thiQKUyw";
		// 実行
		result = servlet.checkPass(entryPassword, truePassword);
		// 検証
		assertThat(result, is(false));
	}

	@Test
	public void 入力パスワードー正しいパスワードーthiQKUywーNULLでFAULSEを返す() {

		// ユーザの入力
		String entryPassword = "thiQKUyw";
		String truePassword = null;
		// 実行
		result = servlet.checkPass(entryPassword, truePassword);
		// 検証
		assertThat(result, is(false));
	}

	@Test
	public void 入力パスワードー正しいパスワードーNULLーNULLでFAULSEを返す() {

		// ユーザの入力
		String entryPassword = null;
		String truePassword = null;
		// 実行
		result = servlet.checkPass(entryPassword, truePassword);
		// 検証
		assertThat(result, is(false));
	}

}