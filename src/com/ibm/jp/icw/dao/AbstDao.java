package com.ibm.jp.icw.dao;

public abstract class AbstDao {

	static {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("エラー: AbstDao#DB2用のドライバーが存在しない");
			e.printStackTrace();
		}
	}
}
