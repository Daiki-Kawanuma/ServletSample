package com.ibm.jp.icw.service;

import java.util.ArrayList;

import com.ibm.jp.icw.dao.BookDAO;
import com.ibm.jp.icw.dao.UserDAOSample;
import com.ibm.jp.icw.dto.BookDTO;
import com.ibm.jp.icw.dto.UserDTO;

/**
 * 本検索サービス
 */
public class SearchBookService {
	/**
	 * 渡されたユーザーIDが有効だった場合、ユーザーに紐づく本のArrayListを返します。<br>
	 * ユーザーがUserListに登録されていない場合は、BookListに無登録のユーザーのデータがあっても返しません。
	 * @param userid - ユーザーのID
	 * @return 本のArrayList。無登録ユーザーであった場合はnullを返す。
	 */
	public static ArrayList<BookDTO> searchBook(String userid) {
		System.out.println("情報：SearchBookService#searchBook 開始");
		System.out.println("情報：SearchBookService#userid:" + userid);

		ArrayList<BookDTO> list = null;

		UserDAOSample userDao = new UserDAOSample();

		System.out.println("情報：SearchBookService#UserDTO取得");
		UserDTO userDto = userDao.getUserByUserid(userid);

		if (userDto != null) {
			System.out.println("情報：SearchBookService#UserDTOがnullではない場合の処理開始");
			BookDAO bookDao = new BookDAO();
			System.out.println("情報：SearchBookService#BookDAOからリスト取得");
			list = bookDao.getBookListByUserid(userid);
		}

		System.out.println("情報：SearchBookService#searchBook 終了");
		return list;
	}
}
