package com.ibm.jp.icw.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilDAO {
	Connection con = null;
	Statement stmt = null;
	static {try {
		Class.forName("com.ibm.db2.jcc.DB2Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	}

	public void init(){
	try {
		con = DriverManager.getConnection("jdbc:db2://dashdb-entry-yp-dal09-09.services.dal.bluemix.net:50000/BLUDB", "dash6930", "3tTdhUB8$gY#");
		stmt = con.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	public void executeUpdate(String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
