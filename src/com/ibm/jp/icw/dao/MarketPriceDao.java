package com.ibm.jp.icw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.jp.icw.constant.DatabaseConstants;
import com.ibm.jp.icw.model.MarketPrice;

public class MarketPriceDao extends BaseDao {

	public static final String COLUMN_BRAND_CODE = "BRAND_CODE";
	public static final String COLUMN_DATE_TIME = "DATE_TIME";
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

			ResultSet resultSet = statement.executeQuery(
					String.format("SELECT * FROM market_price WHERE brand_code = '%s'", brandCode));

			if (resultSet.next()){
				price = new MarketPrice(resultSet.getString(COLUMN_BRAND_CODE),
						resultSet.getDate(COLUMN_DATE_TIME),
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

	public static ArrayList<MarketPrice> getMarketPriceList(String brandCode){

		ArrayList<MarketPrice> priceList = new ArrayList<MarketPrice>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL,
					DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(
					String.format("SELECT * FROM market_price WHERE brand_code = '%s' ORDER BY date_time ASC;", brandCode));

			while (resultSet.next()){
				MarketPrice price = new MarketPrice(resultSet.getString(COLUMN_BRAND_CODE),
						resultSet.getDate(COLUMN_DATE_TIME),
						resultSet.getInt(COLUMN_PRICE));

				priceList.add(price);
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
		return priceList;
	}
}
