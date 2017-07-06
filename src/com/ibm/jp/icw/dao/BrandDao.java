package com.ibm.jp.icw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.jp.icw.constant.DatabaseConstants;
import com.ibm.jp.icw.model.Brand;

public class BrandDao extends BaseDao{
	// TODO 不足しているカラムを足す
	public static final String COLUMN_BRAND_CODE = "BRAND_CODE";
	public static final String COLUMN_BRAND_NAME = "BRAND_NAME";
	public static final String COLUMN_MARKET = "MARKET";
	public static final String COLUMN_INDUSTRY = "INDUSTRY";
	public static final String COLUMN_TRADING_UNIT = "TRADING_UNIT";
	public static final String COLUMN_BRAND_STATUS = "BRAND_STATUS";

	public static ArrayList<Brand> getBrandByBrandCode(String brandCode){

		ArrayList<Brand> brandList = new ArrayList<Brand>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL,
					DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			// TODO クエリを書く
			ResultSet resultSet = statement.executeQuery(
					String.format("SELECT * FROM brand WHERE brand_code = '%s'", brandCode));

			if (resultSet.next()){
				// TODO 数字を ResultSet から入れる
				Brand brand = new Brand(resultSet.getString(COLUMN_BRAND_CODE),
						resultSet.getString(COLUMN_BRAND_NAME),
						resultSet.getString(COLUMN_MARKET),
						resultSet.getString(COLUMN_INDUSTRY),
						resultSet.getInt(COLUMN_TRADING_UNIT),
						resultSet.getString(COLUMN_BRAND_STATUS),
						0,0,0,0,0,0,0,0);

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

			// TODO クエリを書く
			ResultSet resultSet = statement.executeQuery(
					String.format("SELECT * FROM brand WHERE brand_name = '%s'", brandName));

			while (resultSet.next()){
				// TODO 数字を ResultSet から入れる
				Brand brand = new Brand(resultSet.getString(COLUMN_BRAND_CODE),
						resultSet.getString(COLUMN_BRAND_NAME),
						resultSet.getString(COLUMN_MARKET),
						resultSet.getString(COLUMN_INDUSTRY),
						resultSet.getInt(COLUMN_TRADING_UNIT),
						resultSet.getString(COLUMN_BRAND_STATUS),
						0,0,0,0,0,0,0,0);
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
}