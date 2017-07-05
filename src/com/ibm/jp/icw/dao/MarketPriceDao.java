package com.ibm.jp.icw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.jp.icw.constant.DatabaseConstants;
import com.ibm.jp.icw.model.MarketPrice;

public class MarketPriceDao extends BaseDao {

	public static final String COLUMN_BRAND_CODE = "BRAND_CODE";
	public static final String COLUMN_DATE = "DATE";
	public static final String COLUMN_PRICE = "PRICE";

	public static MarketPrice getMarketPrice(String brandCode){

		MarketPrice price = null;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL,
					DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			// TODO クエリを書く
			ResultSet resultSet = statement.executeQuery(
					String.format("SELECT * FROM user WHERE accout_number = '%s'", brandCode));

			if (resultSet.next()){
				price = new MarketPrice(resultSet.getString(COLUMN_BRAND_CODE),
						resultSet.getDate(COLUMN_DATE),
						resultSet.getInt(COLUMN_PRICE));
			}
		} catch (SQLException e) {
			System.err.println("エラー：BrandDao#DBデータ操作時にエラー発生");
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println("エラー：BrandDao#Statementのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.err.println("エラー：BrandDao#connectionのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
		}
		return price;
	}
}
