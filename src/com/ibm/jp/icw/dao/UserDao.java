package com.ibm.jp.icw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.jp.icw.constant.DatabaseConstants;
import com.ibm.jp.icw.model.User;

public class UserDao extends BaseDao {

	public static final String COLUMN_ACCOUNT_NUMBER = "ACCOUNT_NO";
	public static final String COLUMN_USER_NAME = "USER_NAME";
	public static final String COLUMN_LOGIN_PASS = "LOGIN_PASS";
	public static final String COLUMN_BIRTH_DAY = "BIRTH_DAY";
	public static final String COLUMN_MAIL = "MAIL";
	public static final String COLUMN_ACCOUNT_BALANCE = "ACCOUNT_BALANCE";
	public static final String COLUMN_CC_NUMBER = "CC_NUMBER";
	public static final String COLUMN_CC_NAME = "CC_NAME";
	public static final String COLUMN_CC_SEC = "CC_SEC";
	public static final String COLUMN_CC_VALID = "CC_VALID";

	public static User getUser(String accountNumber) {

		User user = null;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL,
					DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(
					String.format("SELECT * FROM user WHERE account_no = '%s'", accountNumber));

			if (resultSet.next()){
				user = new User(resultSet.getString(COLUMN_ACCOUNT_NUMBER),
						resultSet.getString(COLUMN_USER_NAME),
						resultSet.getString(COLUMN_LOGIN_PASS),
						resultSet.getString(COLUMN_CC_NAME),
						resultSet.getString(COLUMN_CC_NUMBER),
						resultSet.getString(COLUMN_CC_SEC),
						resultSet.getDate(COLUMN_CC_VALID));
			}
		} catch (SQLException e) {
			System.err.println("エラー：UserDao#DBデータ操作時にエラー発生");
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println("エラー：UserDao#Statementのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.err.println("エラー：UserDao#connectionのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
		}
		return user;
	}
}
