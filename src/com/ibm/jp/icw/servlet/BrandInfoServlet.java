package com.ibm.jp.icw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.icw.constant.ServletConstants;
import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.model.Brand;
import com.ibm.jp.icw.model.User;

public class BrandInfoServlet extends BaseServlet {

	// 色々定義しときます
	private static final String PARAM_CURRENT_PAGE = "current_page";
	private static final String PARAM_ERROR_MESSAGE = "error_message";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// セッションがありますよ〜何も取得はしないけど、あとで注文入力画面遷移前にユーザー情報と銘柄情報を引き渡すので！
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
		Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);

		String currentPage = (String) request.getAttribute(PARAM_CURRENT_PAGE);
		String nextPage = null;

		switch (currentPage) {

		// [銘柄検索画面]のとき；
		case ServletConstants.BRAND_SEARCH:

			String searchType = request.getParameter("searchtype");
			String searchCondition = request.getParameter("searchcondition");

			// 検索条件の入力が正常である場合、[銘柄一覧画面]に遷移、そうでなければStay
			if (validateInputs(searchType, searchCondition)) {
				nextPage = ServletConstants.BRAND_LIST + ".jsp";
			} else {
				nextPage = ServletConstants.BRAND_SEARCH + ".jsp";
				request.setAttribute(PARAM_ERROR_MESSAGE, "入力に不備があります。銘柄コードは半角数字4桁でご入力ください。");
			}
			break;

		// [銘柄一覧画面]のとき；
		case ServletConstants.BRAND_LIST:
			session.setAttribute(user, user1);
			String actionType = request.getParameter("action");

			// [詳細閲覧]ボタンで[銘柄詳細画面]に遷移し、[買い注文]ボタンなら[買い注文画面]に遷移する
			if (actionType.equals("詳細閲覧")) {
				nextPage = ServletConstants.BRAND_DETAIL + ".jsp";
			} else {
				nextPage = ServletConstants.ORDERS;

				// order = new Order(brand, user);
			}
			break;

		// [銘柄詳細画面]のとき；
		case ServletConstants.BRAND_DETAIL:
			nextPage = ServletConstants.ORDER_ENTRY;
			break;

		default:
			break;
		}
	}

	private boolean validateInputs(String searchType, String searchCondition) {
		if (searchType == null || searchCondition == null)
			return false;

		if (searchType.equals("brandcode")) {

			if (searchCondition.length() > 4 || searchCondition.length() < 4) {
				return false;
			} else {
				try {
					int brandcode = Integer.parseInt(searchCondition);
					return true;
				} catch (NumberFormatException e) {
					return false;
				}

				// TODO: handle exception
			}
		} else
			return true;

	}
}
