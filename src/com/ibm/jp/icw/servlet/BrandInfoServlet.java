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
import com.ibm.jp.icw.dao.MarketPriceDao;
import com.ibm.jp.icw.model.Brand;
import com.ibm.jp.icw.model.MarketPrice;

@WebServlet("/search")
public class BrandInfoServlet extends BaseServlet {

	// 色々定義しときます
	private static final String PARAM_CURRENT_PAGE = "current_page";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String currentPage = (String) request.getParameter(PARAM_CURRENT_PAGE);
		if (currentPage == null)
			currentPage = "";
		String nextPage = null;

		String searchType;
		String searchCondition;

		switch (currentPage) {
		// [銘柄検索画面]のとき；
		case ServletConstants.BRAND_SEARCH:

			searchType = request.getParameter("searchtype");
			searchCondition = request.getParameter("searchcondition");

			// 検索条件の入力が正常である場合、[銘柄一覧画面]に遷移、そうでなければStay
			if (validateInputs(searchType, searchCondition)) {

				ArrayList<Brand> brandList = new ArrayList<Brand>();

				if (searchType.equals("brandcode")) {
					brandList = BrandDao.getBrandByBrandCode(searchCondition);
				} else {
					brandList = BrandDao.getBrandListByBrandName(searchCondition);
				}


				if(brandList.size() != 0){
					nextPage = ServletConstants.BRAND_LIST + ".jsp";
					request.setAttribute("brandList", brandList);
				} else {
					nextPage = ServletConstants.BRAND_SEARCH + ".jsp";
					request.setAttribute("message", "条件に一致する銘柄は0件です。");
				}

			} else {
				nextPage = ServletConstants.BRAND_SEARCH + ".jsp";
				request.setAttribute("message", "入力に不備があります。銘柄コードは半角数字4桁でご入力ください。");
			}
			break;

		// [銘柄一覧画面]のとき；
		case ServletConstants.BRAND_LIST:

			String brandCodeforOrder = request.getParameter("order");
			String brandCodeforDetail = request.getParameter("detail");

			if (brandCodeforDetail == null && brandCodeforOrder == null) {

				searchType = request.getParameter("searchtype");
				searchCondition = request.getParameter("searchcondition");

				if (validateInputs(searchType, searchCondition)) {

					// 結合テスト用のコンソール表示
					System.out.println("BrandCode: " + searchCondition);

					ArrayList<Brand> brandList = new ArrayList<Brand>();

					if (searchType.equals("brandcode")) {
						brandList = BrandDao.getBrandByBrandCode(searchCondition);
					} else {
						brandList = BrandDao.getBrandListByBrandName(searchCondition);
					}

					if (brandList.size() != 0) {
						nextPage = ServletConstants.BRAND_LIST + ".jsp";
						request.setAttribute("brandList", brandList);
					} else {
						nextPage = ServletConstants.BRAND_SEARCH + ".jsp";
						request.setAttribute("message", "条件に一致する銘柄は0件です。");
					}
				} else {
					nextPage = ServletConstants.BRAND_SEARCH + ".jsp";
					request.setAttribute("message", "入力に不備があります。銘柄コードは半角数字4桁でご入力ください。");
				}
				// [詳細閲覧]ボタンで[銘柄詳細画面]に遷移し、[買い注文]ボタンなら[買い注文画面]に遷移する
			} else if (brandCodeforDetail != null) {

				nextPage = ServletConstants.BRAND_DETAIL + ".jsp";

				Brand brand = BrandDao.getBrandDetailByBrandCode(brandCodeforDetail);
				ArrayList<MarketPrice> priceList = MarketPriceDao.getMarketPriceList(brandCodeforDetail);
				priceList.remove(0);

				// 結合テスト用のコンソール表示
				System.out.println("BrandCode: " + brand.getBrandCode());

				request.getSession().setAttribute(SessionConstants.PARAM_BRAND, brand);
				request.setAttribute("priceList", priceList);

			} else if (brandCodeforOrder != null) {

				nextPage = ServletConstants.ORDERS;

				Brand brand = BrandDao.getBrandDetailByBrandCode(brandCodeforOrder);

				// 結合テスト用のコンソール表示
				System.out.println("BrandCode: " + brand.getBrandCode());

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

	public boolean validateInputs(String searchType, String searchCondition) {

		if (searchType == null || searchCondition == null)
			return false;

		if (searchType.equals("") || searchCondition.equals(""))
			return false;

		if (searchType.equals("brandcode")) {
			// 文字長4と正規表現で半角数字をチェック
			if (searchCondition.length() == 4 && searchCondition.matches("^-?[0-9]+$")) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
}
