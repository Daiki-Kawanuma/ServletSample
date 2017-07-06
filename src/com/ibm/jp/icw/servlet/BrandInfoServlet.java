package com.ibm.jp.icw.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.icw.constant.ServletConstants;
import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.dao.BrandDao;
import com.ibm.jp.icw.model.Brand;

@WebServlet("/search")
public class BrandInfoServlet extends BaseServlet {

	// 色々定義しときます
	private static final String PARAM_CURRENT_PAGE = "current_page";
	private static final String PARAM_ERROR_MESSAGE = "error_message";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// セッションがありますよ〜何も取得はしないけど、あとで注文入力画面遷移前にユーザー情報と銘柄情報を引き渡すので！
		//HttpSession session = request.getSession();
		//Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);

		String currentPage = (String) request.getParameter(PARAM_CURRENT_PAGE);
		if(currentPage == null)
			currentPage = "";
		String nextPage = null;

		switch (currentPage) {

		// [銘柄検索画面]のとき；
		case ServletConstants.BRAND_SEARCH:

			String searchType = request.getParameter("searchtype");
			String searchCondition = request.getParameter("searchcondition");

			// 検索条件の入力が正常である場合、[銘柄一覧画面]に遷移、そうでなければStay
			if (validateInputs(searchType, searchCondition)) {
				nextPage = ServletConstants.BRAND_LIST + ".jsp";

				ArrayList<Brand> brandList = new ArrayList<Brand>();

				if (searchType.equals("brandcode")) {
					// TODO テストコード
					//brandList = BrandDao.getBrandByBrandCode(searchCondition);
					brandList.add(new Brand("1234", "トヨタ", "東１", "自動車", 100, "正常",
							0, 0, 0, 0, 0, 0, 0, 0));
				} else {
					brandList = BrandDao.getBrandListByBrandName(searchCondition);
				}
				request.setAttribute("brandList", brandList);
			} else {
				nextPage = ServletConstants.BRAND_SEARCH + ".jsp";
				request.setAttribute(PARAM_ERROR_MESSAGE, "入力に不備があります。銘柄コードは半角数字4桁でご入力ください。");
			}
			break;

		// [銘柄一覧画面]のとき；
		case ServletConstants.BRAND_LIST:

			String brandCodeforOrder = request.getParameter("order");
			String brandCodeforDetail = request.getParameter("detail");

			// [詳細閲覧]ボタンで[銘柄詳細画面]に遷移し、[買い注文]ボタンなら[買い注文画面]に遷移する
			if (brandCodeforDetail != null) {
				nextPage = ServletConstants.BRAND_DETAIL + ".jsp";
				//Brand brand = BrandDao.getBrandByBrandCode(brandCodeforDetail).get(0);

				// TODO テストコード
				System.out.println("BrandCode: " + brandCodeforDetail );
				Brand brand = new Brand("1234", "トヨタ", "東１", "自動車", 100, "正常",
						0, 0, 0, 0, 0, 0, 0, 0);

				request.getSession().setAttribute(SessionConstants.PARAM_BRAND, brand);
			} else if(brandCodeforOrder != null){
				nextPage = ServletConstants.ORDERS;
				//Brand brand = BrandDao.getBrandByBrandCode(brandCodeforOrder).get(0);

				// TODO テストコード
				System.out.println("BrandCode: " + brandCodeforDetail );
				Brand brand = new Brand("1234", "トヨタ", "東１", "自動車", 100, "正常",
						0, 0, 0, 0, 0, 0, 0, 0);

				request.getSession().setAttribute(SessionConstants.PARAM_BRAND, brand);
			}
			break;

		// [銘柄詳細画面]のとき；
		case ServletConstants.BRAND_DETAIL:
			nextPage = ServletConstants.ORDERS;
			break;

		default:
			nextPage = ServletConstants.BRAND_SEARCH + ".jsp";
			break;
		}
		request.getRequestDispatcher("/" + nextPage).forward(request, response);
	}

	private boolean validateInputs(String searchType, String searchCondition) {

		System.out.println("Type: " + searchType);
		System.out.println("Condition: " + searchCondition);

		if (searchType == null || searchCondition == null)
			return false;

		if (searchType.equals("brandcode")) {

			if (searchCondition.length() != 4) {
				return false;
			} else {
				try {
					Integer.parseInt(searchCondition);
					return true;
				} catch (NumberFormatException e) {
					return false;
				}

				// TODO: handle exception
			}
		} else{
			return true;
		}
	}
}
