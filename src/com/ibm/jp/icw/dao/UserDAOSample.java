package com.ibm.jp.icw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.jp.icw.dto.UserDTO;

/**
 * UserListテーブルにアクセスする為のDAOです。
 */
public class UserDAOSample {
	static {
		System.out.println("情報：UserDAO#スタティックイニシャライザ 開始");
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("情報：UserDAO#スタティックイニシャライザ 終了");
		} catch (ClassNotFoundException e) {
			System.out.println("エラー：UserDAO#DB2用のドライバーが無い");
			e.printStackTrace();
		}
	}

	/**
	 * useridをキーにUserListテーブルを検索し、ユーザーを返します。
	 * @param userid - ユーザーのID
	 * @return ユーザーのDTO。ユーザーがいない場合はnullを返す。
	 */
	public UserDTO getUserByUserid(String userid) {
		System.out.println("情報：UserDAO#getUserByUserid 開始");
		System.out.println("情報：UserDAO#userid：" + userid);

		UserDTO userDto = null;
		Connection con = null;
		Statement stmt = null;

		try {
			System.out.println("情報：UserDAO#DB接続開始");

			con = DriverManager.getConnection("jdbc:db2://dashdb-entry-yp-dal09-09.services.dal.bluemix.net:50000/BLUDB", "dash6930", "3tTdhUB8$gY#");
			stmt = con.createStatement();

			System.out.println("情報：UserDAO#SQL実行");

			ResultSet rs = stmt.executeQuery("select * from user_list where user_id='" + userid + "'");

			System.out.println("情報：UserDAO#SQLの実行結果をUserDTOのインスタンスにセットする");

			if (rs.next()){
				String username = rs.getString("USER_NAME");
				userDto = new UserDTO(userid, username);
			}
		} catch (SQLException e) {
			System.out.println("エラー：UserDAO#DBデータ操作時にエラー発生");

			e.printStackTrace();
		} finally {
			System.out.println("情報：UserDAO#finally処理開始");
			if (stmt != null) {
				System.out.println("情報：UserDAO#statementがnullではない場合の処理開始");
				try {
					System.out.println("情報：UserDAO#statementのクローズ処理開始");
					stmt.close();
					System.out.println("情報：UserDAO#statementのクローズ処理終了");
				} catch (SQLException e) {
					System.out.println("エラー：UserDAO#statementのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
			if (con != null) {
				System.out.println("情報：UserDAO#connectionがnullではない場合の処理開始");
				try {
					System.out.println("情報：UserDAO#connectionのクローズ処理終了");
					con.close();
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
