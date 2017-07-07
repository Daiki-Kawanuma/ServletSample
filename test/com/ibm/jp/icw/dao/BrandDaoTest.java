package com.ibm.jp.icw.dao;

import org.junit.After;
import org.junit.Before;

import com.ibm.jp.icw.dao.util.UtilDAO;

public class BrandDaoTest {

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
}