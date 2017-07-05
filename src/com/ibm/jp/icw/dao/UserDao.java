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
	public static final String COLUMN_CC_NO = "CC_NO";
	public static final String COLUMN_CC_NAME = "CC_NAME";
	public static final String COLUMN_CC_SEC = "CC_SEC";
	public static final String COLUMN_CC_VALID = "CC_VALID";

	public User getUser(String accountNumber) {

		User user = null;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL,
					DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(
					String.format("SELECT * FROM user WHERE accout_number = '%s'", accountNumber));

			if (resultSet.next()){
				user = new User(resultSet.getString(COLUMN_ACCOUNT_NUMBER),
						resultSet.getString(COLUMN_CC_NAME),
						resultSet.getString(COLUMN_CC_NO));
			}
		} catch (SQLException e) {
			System.out.println("エラー：UserDAO#DBデータ操作時にエラー発生");

			e.printStackTrace();
		} finally {
			System.out.println("情報：UserDAO#finally処理開始");
			if (statement != null) {
				System.out.println("情報：UserDAO#statementがnullではない場合の処理開始");
				try {
					System.out.println("情報：UserDAO#statementのクローズ処理開始");
					statement.close();
					System.out.println("情報：UserDAO#statementのクローズ処理終了");
				} catch (SQLException e) {
					System.out.println("エラー：UserDAO#statementのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
			if (connection != null) {
				System.out.println("情報：UserDAO#connectionがnullではない場合の処理開始");
				try {
					System.out.println("情報：UserDAO#connectionのクローズ処理終了");
					connection.close();
					System.out.println("情報：UserDAO#connectionのクローズ処理終了");
				} catch (SQLException e) {
					System.out.println("エラー：UserDAO#connectionのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
		}

		System.out.println("情報：BookDAO#getBookListByUserid 終了");
		return userDto;

	}
}
