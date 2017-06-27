package com.ibm.jp.icw.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jp.icw.dao.util.UtilDAO;
import com.ibm.jp.icw.dto.BookDTO;


public class BookDAOTest {

	UtilDAO utilDao = new UtilDAO();
	String testUserid = "junituser";
	String testBookid = "DUMMY";

	@Before
	public void setUp() throws Exception {
		utilDao.init();
		// user_book_listにダミーデータが残っていた場合に備えて削除
		utilDao.executeUpdate("delete from user_book_list where user_id='" + testUserid + "'");
		// book_listにダミーデータが残っていた場合に備えて削除
		utilDao.executeUpdate("delete from book_list where book_id='" + testBookid + "'");
		// user_listにダミーデータが残っていた場合に備えて削除
		utilDao.executeUpdate("delete from user_list where user_id='" + testUserid + "'");
	}

	@After
	public void tearDown() throws Exception {
		utilDao.executeUpdate("delete from user_book_list where user_id='" + testUserid + "'");
		utilDao.executeUpdate("delete from book_list where book_id='" + testBookid + "'");
		utilDao.executeUpdate("delete from user_list where user_id='" + testUserid + "'");
		utilDao.close();
	}

	@Test
	public void ユーザーのデータがない場合は取得結果は0() {
		BookDAO bookDao = new BookDAO();
		ArrayList<BookDTO> list = bookDao.getBookListByUserid(testUserid);
		assertThat(list.size(), is(0));
	}

	@Test
	public void ユーザーのデータが1つで取得結果も1つ() {
		String bookName = "BookName";
		String author = "Hasegawa";
		int price = 100;
		// book_listにダミーデータ挿入
		utilDao.executeUpdate("insert into book_list values('" + testBookid + "','" + bookName + "','" + author + "'," + price + ")");
		// user_listにダミーデータ挿入
		utilDao.executeUpdate("insert into user_list (USER_ID, USER_NAME) values('" + testUserid + "','testUser')");
		// user_book_listにダミーデータ挿入
		utilDao.executeUpdate("insert into user_book_list values ('999','" + testUserid + "','" + testBookid + "')");
		BookDAO bookDao = new BookDAO();
		ArrayList<BookDTO> list = bookDao.getBookListByUserid(testUserid);
		assertThat(list.size(), is(1));
		assertThat(list.get(0).getName(), is(bookName));
		assertThat(list.get(0).getAuthor(), is(author));
		assertThat(list.get(0).getPrice(), is(price));
	}

	@Test
	public void テーブルのカラムが変更された場合空のリストが返る(){

		String bookName = "BookName";
		String author = "Hasegawa";
		int price = 100;
		// book_listにダミーデータ挿入
		utilDao.executeUpdate("insert into book_list values('" + testBookid + "','" + bookName + "','" + author + "'," + price + ")");
		// user_listにダミーデータ挿入
		utilDao.executeUpdate("insert into user_list (USER_ID, USER_NAME) values('" + testUserid + "','testUser')");
		// user_book_listにダミーデータ挿入
		utilDao.executeUpdate("insert into user_book_list values ('999','" + testUserid + "','" + testBookid + "')");

		utilDao.executeUpdate("alter table BOOK_LIST rename column BOOK_NAME to BOOKNAME");

		BookDAO bookDao = new BookDAO();
		ArrayList<BookDTO> list = bookDao.getBookListByUserid(testUserid);
		assertThat(list.size(), is(0));

		utilDao.executeUpdate("alter table BOOK_LIST rename column BOOKNAME to BOOK_NAME");
	}

}
