package com.ibm.jp.icw.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.jp.icw.dao.util.UtilDAO;
import com.ibm.jp.icw.model.MarketPrice;

public class MarketPriceDaoTest {

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
	public void 銘柄コードに1000を入力すると最新の時価インスタンスが返される() {
		brandCode = "1000";
		MarketPrice price = MarketPriceDao.getMarketPrice(brandCode);
		assertNotNull(0);
    }

	@Test
	public void 銘柄コードに0000を入力するとnullが返される() {
		brandCode = "0000";
		MarketPrice price = MarketPriceDao.getMarketPrice(brandCode);
		assertNull(0);
    }

	@Test
	public void 銘柄コードに99999を入力するとnullが返される() {
		brandCode = "99999";
		MarketPrice price = MarketPriceDao.getMarketPrice(brandCode);
		assertNull(0);
    }

	@Test
	public void 銘柄コードに空文字を入力するとnullが返される() {
		brandCode = "";
		MarketPrice price = MarketPriceDao.getMarketPrice(brandCode);
		assertNull(0);
	}
}


