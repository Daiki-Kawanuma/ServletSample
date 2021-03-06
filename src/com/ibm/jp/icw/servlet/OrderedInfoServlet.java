package com.ibm.jp.icw.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.icw.constant.ServletConstants;
import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.dao.OrderDao;
import com.ibm.jp.icw.model.Order;
import com.ibm.jp.icw.model.User;

/**
 * Servlet implementation class OrderedInfoServlet
 */
@WebServlet("/orderedinfo")
public class OrderedInfoServlet extends BaseServlet {
	// 色々定義しときます
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute(SessionConstants.PARAM_USER);
		String nextPage = null;

		String searchReceptNo;
		searchReceptNo = request.getParameter("searchreceptno");

		ArrayList<Order> orderList = new ArrayList<Order>();

		if (searchReceptNo != null) {
			nextPage = ServletConstants.ORDEREDINFOS + ".jsp";
			orderList = OrderDao.getOrderByReceptionNumber(user.getAccountNumber(), searchReceptNo);
			request.setAttribute("orderlist", orderList);

			if (orderList.size() == 0) {
				request.setAttribute("message", "ご入力された受付番号に一致する注文情報がありません。");
			}
			request.getRequestDispatcher("orderdinfo.jsp").forward(request, response);
		} else {
			/*
			 * Debug ArrayList<Order> orderList = new ArrayList<Order>(); Brand
			 * brand = new Brand("1234", "トヨタ", "東１", "自動車", 100, "正常", 0, 0, 0,
			 * 0, 0, 0, 0, 0, 0); for(int i = 1; i <= 10; i++){ Order order =
			 * new Order(brand, user, Order.OrderType.成行,
			 * Order.OrderCondition.無条件, 100, 100, new Date());
			 * orderList.add(order); } /
			 */
			orderList = OrderDao.getOrderList(user.getAccountNumber());
			// */
			nextPage = ServletConstants.BRAND_DETAIL + ".jsp";

			if (orderList.size() == 0) {
				request.setAttribute("message", "注文情報がありません。");
			}

			request.setAttribute("orderlist", orderList);

			request.getRequestDispatcher("orderdinfo.jsp").forward(request, response);
		}
	}
}
