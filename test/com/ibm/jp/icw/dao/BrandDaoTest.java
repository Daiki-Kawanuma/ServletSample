package com.ibm.jp.icw.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jp.icw.dao.util.UtilDAO;
import com.ibm.jp.icw.model.Brand;

public class BrandDaoTest {

	UtilDAO utilDao = new UtilDAO();
	String brandCode;

	@Before
	public void setUp() throws Exception {
		utilDao.init();
	}

	@After
	public void tearDown() throws Exception {
		utilDao.close();
	}

	@Test
	public void getBrandbyBrandCode1332で正常に返る() {
		brandCode = "1332";
		ArrayList<Brand> list = BrandDao.getBrandByBrandCode(brandCode);
		assertThat(list.size(), not(0));
	}

	@Test
	public void getBrandbyBrandCode0000は正常に返らない() {
		brandCode = "0000";
		ArrayList<Brand> list = BrandDao.getBrandByBrandCode(brandCode);
		assertThat(list.size(), is(0));
	}

	@Test
	public void getBrandbyBrandCode99999は正常に返らない() {
		brandCode = "99999";
		ArrayList<Brand> list = BrandDao.getBrandByBrandCode(brandCode);
		assertThat(list.size(), is(0));
	}

	@Test
	public void etBrandbyBrandCod空は正常に返らない() {
		brandCode = "";
		ArrayList<Brand> list = BrandDao.getBrandByBrandCode(brandCode);
		assertThat(list.size(), is(0));
	}
}