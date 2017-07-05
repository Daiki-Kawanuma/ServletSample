package com.ibm.jp.icw.dao;

import com.ibm.jp.icw.model.MarketPrice;

public class MarketPriceDao extends BaseDao {

	public static MarketPrice getFairPrice(){
		return new MarketPrice();
	}
}
