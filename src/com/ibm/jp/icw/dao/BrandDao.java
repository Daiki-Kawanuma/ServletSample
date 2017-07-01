package com.ibm.jp.icw.dao;

import com.ibm.jp.icw.model.Brand;

public class BrandDao extends BaseDao{

	public static Brand getBrand(int brandCode){
		return new Brand();
	}
}