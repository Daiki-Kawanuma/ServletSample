package com.ibm.jp.icw.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ibm.jp.icw.dto.BookDTO;

public class SearchBookServiceTest {

	@Test
	public void 登録済で本を1冊所有しているユーザーIDで検索した際に本データが1件返ってくる() {
		// 事前準備
		SearchBookService testTarget = new SearchBookService();
		String testUserId = "user1";
		// 実行
		ArrayList<BookDTO> list = testTarget.searchBook(testUserId);
		// 検証
		assertThat(list.size(), is(1));
		// 後処理（今回はなし）
	}

}
