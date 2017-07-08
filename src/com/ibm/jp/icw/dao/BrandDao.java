package com.ibm.jp.icw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.jp.icw.constant.DatabaseConstants;
import com.ibm.jp.icw.model.Brand;
import com.ibm.jp.icw.util.DateUtil;

public class BrandDao extends BaseDao{
	// TODO 不足しているカラムを足す
	public static final String COLUMN_BRAND_CODE = "BRAND_CODE";
	public static final String COLUMN_BRAND_NAME = "BRAND_NAME";
	public static final String COLUMN_MARKET = "MARKET";
	public static final String COLUMN_INDUSTRY = "INDUSTRY";
	public static final String COLUMN_TRADING_UNIT = "TRADING_UNIT";
	public static final String COLUMN_BRAND_STATUS = "BRAND_STATUS";
	public static final String COLUMN_MARKET_PRICE = "MARKET_PRICE";
	public static final String COLUMN_OPENING_PRICE = "OPEN_PRICE";
	public static final String COLUMN_CLOSE_PRICE = "END_PRICE";
	public static final String COLUMN_HIGH_PRICE = "HIGH_PRICE";
	public static final String COLUMN_LOW_PRICE = "LOW_PRICE";
	public static final String COLUMN_OFFER_PRICE = "OFFER_PRICE";
	public static final String COLUMN_BID_PRICE = "BID_PRICE";
	public static final String COLUMN_YEAR_HIGH = "YEAR_HIGH";
	public static final String COLUMN_YEAR_LOW = "YEAR_LOW";

	public static ArrayList<Brand> getBrandByBrandCode(String brandCode){

		ArrayList<Brand> brandList = new ArrayList<Brand>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL,
					DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			String query = "WITH now_price AS (SELECT price FROM market_price WHERE brand_code = '" + brandCode
					+ "' ORDER BY date_time DESC FETCH FIRST 1 ROWS ONLY) "
					+ "SELECT brand.*, now_price.price FROM brand, now_price WHERE brand.brand_code = '" + brandCode + "';";

			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()){

				Brand brand = new Brand(resultSet.getString(COLUMN_BRAND_CODE),
						resultSet.getString(COLUMN_BRAND_NAME),
						resultSet.getString(COLUMN_MARKET),
						resultSet.getString(COLUMN_INDUSTRY),
						resultSet.getInt(COLUMN_TRADING_UNIT),
						resultSet.getString(COLUMN_BRAND_STATUS),
						resultSet.getInt(MarketPriceDao.COLUMN_PRICE));

				brandList.add(brand);
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
		return brandList;
	}

	public static ArrayList<Brand> getBrandListByBrandName(String brandName){

		ArrayList<Brand> brandList = new ArrayList<Brand>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL,
					DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			String query = "WITH now_price AS (SELECT * FROM market_price WHERE date_time = '" + DateUtil.getNowTime() +"') "
					+ "SELECT brand.*, now_price.price FROM brand, now_price WHERE brand_name LIKE '" + brandName
					+ "%' AND brand.brand_code = now_price.brand_code ORDER BY brand_code ASC;";

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()){

				Brand brand = new Brand(resultSet.getString(COLUMN_BRAND_CODE),
						resultSet.getString(COLUMN_BRAND_NAME),
						resultSet.getString(COLUMN_MARKET),
						resultSet.getString(COLUMN_INDUSTRY),
						resultSet.getInt(COLUMN_TRADING_UNIT),
						resultSet.getString(COLUMN_BRAND_STATUS),
						resultSet.getInt(MarketPriceDao.COLUMN_PRICE));

				brandList.add(brand);
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
		return brandList;
	}

	public static Brand getBrandDetailByBrandCode(String brandCode){

		Brand brand = null;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL,
					DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			String todayDate = DateUtil.getTodayDate();
			String todayMinTime = DateUtil.getTodayMinTime();
			String todayMaxTime = DateUtil.getTodayMaxTime();
			String yesterdayMaxTime = DateUtil.getYesterdayMaxTime();
			String yearMinTime = DateUtil.getYearMinTime();
			String yearMaxTime = DateUtil.getYearMaxTime();

			String query = "WITH brand_values AS (SELECT * FROM market_price WHERE brand_code = '"+ brandCode + "'), "
					+ String.format("year_values AS (SELECT MAX(price) AS year_high, MIN(price) AS year_low FROM brand_values WHERE date_time > '%s' AND date_time < '%s'), ", yearMinTime, yearMaxTime)
					+ String.format("today_values AS (SELECT MAX(price) AS high_price, MIN(price) AS low_price FROM brand_values WHERE date_time >= '%s' AND date_time <= '%s'), ", todayMinTime, todayMaxTime)
					+ String.format("end_value AS (SELECT price AS end_price FROM brand_values WHERE date_time = '%s'), ", yesterdayMaxTime)
					+ String.format("open_value AS (SELECT price AS open_price FROM brand_values WHERE date_time = '%s'), ", todayMinTime)
					+ String.format("offer_value AS (SELECT order_unit_price AS offer_price FROM order WHERE order_date = '%s' AND trading_type = 'S' GROUP BY order_unit_price ORDER BY COUNT(*) DESC FETCH FIRST 1 ROWS ONLY), ", todayDate)
					+ String.format("bid_value AS (SELECT order_unit_price AS bid_price FROM order WHERE order_date = '%s' AND trading_type = 'B' GROUP BY order_unit_price ORDER BY COUNT(*) DESC FETCH FIRST 1 ROWS ONLY), ", todayDate)
					+ String.format("now_value AS (SELECT price AS market_price FROM market_price WHERE brand_code = '%s' ORDER BY date_time DESC FETCH FIRST 1 ROWS ONLY) ", brandCode)
					+ "SELECT * FROM brand, year_values, today_values, end_value, open_value, offer_value, bid_value, now_value WHERE brand_code = '" + brandCode + "';";

			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()){

				brand = new Brand(resultSet.getString(COLUMN_BRAND_CODE),
						resultSet.getString(COLUMN_BRAND_NAME),
						resultSet.getString(COLUMN_MARKET),
						resultSet.getString(COLUMN_INDUSTRY),
						resultSet.getInt(COLUMN_TRADING_UNIT),
						resultSet.getString(COLUMN_BRAND_STATUS),
						resultSet.getInt(COLUMN_MARKET_PRICE),
						resultSet.getInt(COLUMN_OPENING_PRICE),
						resultSet.getInt(COLUMN_CLOSE_PRICE),
						resultSet.getInt(COLUMN_HIGH_PRICE),
						resultSet.getInt(COLUMN_LOW_PRICE),
						resultSet.getInt(COLUMN_OFFER_PRICE),
						resultSet.getInt(COLUMN_BID_PRICE),
						resultSet.getInt(COLUMN_YEAR_HIGH),
						resultSet.getInt(COLUMN_YEAR_LOW));
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
		return brand;
	}
}