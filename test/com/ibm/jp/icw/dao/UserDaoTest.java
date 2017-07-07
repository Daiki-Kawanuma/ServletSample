package com.ibm.jp.icw.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jp.icw.dao.util.UtilDAO;
import com.ibm.jp.icw.dto.UserDTO;

public class UserDaoTest {

	UtilDAO utilDao = new UtilDAO();
	String nonRegUserId = "nonRegUserId";
	String testUserid = "junituser";

	@Before
	public void setUp() throws Exception {
		utilDao.init();
		utilDao.executeUpdate("delete from user_list where user_id='" + nonRegUserId + "'");
		utilDao.executeUpdate("delete from user_list where user_id='" + testUserid + "'");
	}

	@After
	public void tearDown() throws Exception {
		utilDao.executeUpdate("delete from user_list where user_id='" + nonRegUserId + "'");
		utilDao.executeUpdate("delete from user_list where user_id='" + testUserid + "'");
		utilDao.close();
	}

	@Test
	public void ユーザーが登録されていない場合nullを返す() {
		UserDAOSample userDao = new UserDAOSample();
		UserDTO userDto = userDao.getUserByUserid(nonRegUserId);
		assertThat(userDto, is(nullValue()));
	}

	@Test
	public void ユーザーが1件登録されている場合そのユーザーのデータを返す() {
		String username = "junitusername";
		utilDao.executeUpdate("insert into user_list (USER_ID, USER_NAME) values ('" + testUserid + "','" + username + "')");
		UserDAOSample userDao = new UserDAOSample();
		UserDTO userDto = userDao.getUserByUserid(testUserid);
		assertThat(userDto.getUserid(), is(testUserid));
		assertThat(userDto.getUsername(), is(username));
	}

	@Test
	public void alter() {
		String username = "junitusername";
		utilDao.executeUpdate("insert into user_list (USER_ID, USER_NAME) values ('" + testUserid + "','" + username + "')");

		utilDao.executeUpdate("alter table USER_LIST rename column USER_NAME to USERNAME");

		UserDAOSample userDao = new UserDAOSample();
		UserDTO userDto = userDao.getUserByUserid(testUserid);
		assertThat(userDto, is(nullValue()));

		utilDao.executeUpdate("alter table USER_LIST rename column USERNAME to USER_NAME");
	}

}
