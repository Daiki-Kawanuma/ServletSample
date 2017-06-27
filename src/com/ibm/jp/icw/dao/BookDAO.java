package com.ibm.jp.icw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.jp.icw.dto.BookDTO;

/**
 * BookListテーブルにアクセスする為のDAOです。
 */
public class BookDAO {
	static {
		System.out.println("情報：BookDAO#スタティックイニシャライザ 開始");
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("情報：BookDAO#スタティックイニシャライザ 終了");
		} catch (ClassNotFoundException e) {
			System.out.println("エラー：BookDAO#DB2用のドライバーが無い");
			e.printStackTrace();
		}
	}

	/**
	 * useridをキーにBookListテーブルを検索し、本のリストを返します。
	 * @param userid - ユーザーのID
	 * @return 本のArrayList。検索結果が0の場合は空のArrayListを返す。nullにはならない。
	 */
	public ArrayList<BookDTO> getBookListByUserid(String userid) {
		System.out.println("情報：BookDAO#getBookListByUserid 開始");
		System.out.println("情報：BookDAO#userid：" + userid);

		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		Connection con = null;
		Statement stmt = null;

		try {
			System.out.println("情報：BookDAO#DB接続開始");

			con = DriverManager.getConnection("jdbc:db2://dashdb-entry-yp-dal09-09.services.dal.bluemix.net:50000/BLUDB", "dash6930", "3tTdhUB8$gY#");
			stmt = con.createStatement();

			System.out.println("情報：BookDAO#SQL実行");

			ResultSet rs = stmt.executeQuery("select * from book_list where book_id in (select book_id from user_book_list where user_id='" + userid + "')");

			System.out.println("情報：BookDAO#SQLの実行結果をBookDTOのインスタンスにセットしていく");

			while (rs.next()) {
				BookDTO book = new BookDTO();
				book.setName(rs.getString("BOOK_NAME"));
				book.setAuthor(rs.getString("AUTHOR"));
				book.setPrice(rs.getInt("PRICE"));
				list.add(book);
			}
		} catch (SQLException e) {
			System.out.println("エラー：BookDAO#DBデータ操作時にエラー発生");

			e.printStackTrace();
		} finally {
			System.out.println("情報：BookDAO#finally処理開始");
			if (stmt != null) {
				System.out.println("情報：BookDAO#statementがnullではない場合の処理開始");
				try {
					System.out.println("情報：BookDAO#statementのクローズ処理開始");
					stmt.close();
					System.out.println("情報：BookDAO#statementのクローズ処理終了");
				} catch (SQLException e) {
					System.out.println("エラー：BookDAO#statementのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
			if (con != null) {
				System.out.println("情報：BookDAO#connectionがnullではない場合の処理開始");
				try {
					System.out.println("情報：BookDAO#connectionのクローズ処理終了");
					con.close();
					System.out.println("情報：BookDAO#connectionのクローズ処理終了");
				} catch (SQLException e) {
					System.out.println("エラー：BookDAO#connectionのクローズ処理時にエラー発生");
					e.printStackTrace();
				}
			}
		}

		System.out.println("情報：BookDAO#getBookListByUserid 終了");
		return list;
	}
}
