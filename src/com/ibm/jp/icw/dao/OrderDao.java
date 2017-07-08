package com.ibm.jp.icw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.ibm.jp.icw.constant.DatabaseConstants;
import com.ibm.jp.icw.model.Brand;
import com.ibm.jp.icw.model.Order;
import com.ibm.jp.icw.model.User;

public class OrderDao extends BaseDao {

	public static final String COLUMN_RECEPTION_NUMBER = "RECEPTION_NO";
	public static final String COLUMN_TRADING_TYPE = "TRADING_TYPE";
	public static final String COLUMN_ORDER_TYPE = "ORDER_TYPE";
	public static final String COLUMN_ORDER_CONDITION = "ORDER_CONDITION";
	public static final String COLUMN_ORDER_AMOUNT = "ORDER_AMOUNT";
	public static final String COLUMN_CLOSING_AMOUNT = "CLOSING_AMOUNT";
	public static final String COLUMN_ORDER_UNIT_PRICE = "ORDER_UNIT_PRICE";
	public static final String COLUMN_CLOSING_UNIT_PRICE = "CLOSING_UNIT_PRICE";
	public static final String COLUMN_ORDER_DATE = "ORDER_DATE";
	public static final String COLUMN_CLOSING_DATE = "CLOSING_DATE";
	public static final String COLUMN_ORDER_STATUS = "ORDER_STATUS";

	/**
	 * あるユーザの注文全てを取得する
	 *
	 * @param accountNumber
	 * @return
	 */
	public static ArrayList<Order> getOrderList(String accountNumber) {

		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			ResultSet resultSet = statement
					.executeQuery(String.format("SELECT * FROM user WHERE accout_number = '%s'", accountNumber));

			while (resultSet.next()) {

				User user = new User(resultSet.getString(UserDao.COLUMN_ACCOUNT_NUMBER),
						resultSet.getString(UserDao.COLUMN_USER_NAME), resultSet.getString(UserDao.COLUMN_LOGIN_PASS),
						resultSet.getString(UserDao.COLUMN_MAIL), resultSet.getDate(UserDao.COLUMN_BIRTH_DAY),
						resultSet.getInt(UserDao.COLUMN_ACCOUNT_BALANCE),
						resultSet.getString(UserDao.COLUMN_CC_NAME), resultSet.getString(UserDao.COLUMN_CC_NUMBER),
						resultSet.getString(UserDao.COLUMN_CC_SEC), resultSet.getDate(UserDao.COLUMN_CC_VALID));

				Brand brand = new Brand(resultSet.getString(BrandDao.COLUMN_BRAND_CODE),
						resultSet.getString(BrandDao.COLUMN_BRAND_NAME), resultSet.getString(BrandDao.COLUMN_MARKET),
						resultSet.getString(BrandDao.COLUMN_INDUSTRY), resultSet.getInt(BrandDao.COLUMN_TRADING_UNIT),
						resultSet.getString(BrandDao.COLUMN_BRAND_STATUS), 0, 0, 0, 0, 0, 0, 0, 0, 0);

				Order order = new Order(resultSet.getLong(COLUMN_RECEPTION_NUMBER), brand, user,
						Order.OrderType.getEnum(resultSet.getString(COLUMN_ORDER_TYPE)),
						Order.OrderCondition.getEnum(resultSet.getString(COLUMN_ORDER_CONDITION)),
						resultSet.getInt(COLUMN_ORDER_AMOUNT), resultSet.getInt(COLUMN_CLOSING_AMOUNT),
						resultSet.getDouble(COLUMN_ORDER_UNIT_PRICE), resultSet.getDouble(COLUMN_CLOSING_UNIT_PRICE),
						resultSet.getDate(COLUMN_ORDER_DATE), resultSet.getDate(COLUMN_CLOSING_DATE),
						Order.OrderStatus.getEnum(resultSet.getString(COLUMN_ORDER_STATUS)));

				orderList.add(order);
			}
		} catch (SQLException e) {
			System.err.println("エラー：OrderDao#DBデータ操作時にエラー発生");
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println("エラー：OrderDao#Statementのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.err.println("エラー：OrderDao#connectionのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
		}
		return orderList;
	}

	public static Order registOrder(Order order) {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USER,
					DatabaseConstants.PASSWORD);
			statement = connection.createStatement();

			ResultSet maxResult = statement.executeQuery("SELECT MAX(reception_no) AS " + COLUMN_RECEPTION_NUMBER + " FROM order");
			int maxReceptionNo = 1;
			if (maxResult.next()) {
				maxReceptionNo = maxResult.getInt(COLUMN_RECEPTION_NUMBER) + 1;
			}

			statement.executeQuery(String.format(
					"INSERT INTO order VALUES (%d,'%s', '%s', '%s', '%s', '%s', %d, null, %d, to_date('%S','yyyy/mm/dd'), null, '%s');",
					maxReceptionNo, order.getBrand().getBrandCode(), order.getUser().getAccountNumber(),
					order.getTradingType(), order.getOrderType().toString(), order.getOrderConditions().toString(),
					order.getOrderAmount(), order.getOrderUnitPrice(),
					new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate()), "注文中"));
			order.setReceptionNumber(maxReceptionNo);
			return order;

		} catch (SQLException e) {
			System.err.println("エラー：OrderDao#DBデータ操作時にエラー発生");
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println("エラー：OrderDao#Statementのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.err.println("エラー：OrderDao#connectionのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
