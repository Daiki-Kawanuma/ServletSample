package com.ibm.jp.icw.dao;

import com.ibm.jp.icw.model.Order;

public class OrderDao extends BaseDao {

	/**
	 * あるユーザの注文全てを取得する
	 * @param accountNumber
	 * @return
	 */
	public static Order getOrder(int accountNumber){
		return new Order();
	}
}
