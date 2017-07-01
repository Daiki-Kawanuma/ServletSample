package com.ibm.jp.icw.dao;

import com.ibm.jp.icw.model.FairPrice;

public class FairPriceDao extends BaseDao {

	public static FairPrice getFairPrice(){
		return new FairPrice();
	}
}
