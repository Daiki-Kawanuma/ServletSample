package com.ibm.jp.icw.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.icw.constant.ServletConstants;
import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.model.Brand;
import com.ibm.jp.icw.model.Order;
import com.ibm.jp.icw.model.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private static final String PARAM_CURRENT_PAGE = "CURRENT_PAGE";
	private static final String PARAM_ORDER_TYPE = "ORDER_TYPE";
	private static final String PARAM_ORDER_CONDITION = "ORDER_CONDITION";
	private static final String PARAM_ORDER_AMOUNT = "ORDER_AMOUNT";
	private static final String PARAM_ORDER_UNIT_PRICE = "ORDER_UNIT_PRICE";
	private static final String PARAM_ERROR_MESSAGE = "ERROR_MESSAGE";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
		Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);
		Order order = (Order) session.getAttribute(SessionConstants.PARAM_ORDER);

		String currentPage = (String) request.getAttribute(PARAM_CURRENT_PAGE);
		String nextPage = null;

		switch (currentPage) {
		case ServletConstants.ORDER_ENTRY:

			String orderType = (String) request.getAttribute(PARAM_ORDER_TYPE);
			String orderCondition = (String) request.getAttribute(PARAM_ORDER_CONDITION);
			String orderAmout  = (String) request.getAttribute(PARAM_ORDER_AMOUNT);
			String orderUnitPrice = (String) request.getAttribute(PARAM_ORDER_UNIT_PRICE);

			if(validateInputs(orderType, orderCondition, orderAmout,orderUnitPrice)){

				nextPage = ServletConstants.ORDER_CONFIRM + ".jsp";

			} else {

				nextPage = ServletConstants.ORDER_ENTRY + ".jsp";

				order = new Order(brand, user, Order.OrderType.getEnum(orderType),
						Order.OrderCondition.getEnum(orderCondition),
						Integer.parseInt(orderAmout), Integer.parseInt(orderUnitPrice), new Date());

				session.setAttribute(SessionConstants.PARAM_ORDER, order);
			}
			break;
		case ServletConstants.ORDER_CONFIRM:
			nextPage = ServletConstants.ORDER_COMPLETE + ".jsp";
			break;
		case ServletConstants.ORDER_COMPLETE:
			nextPage = ServletConstants.MY_PAGE;
			break;
		default:
			break;
		}

		response.sendRedirect(nextPage);
	}

	/**
	 *
	 * @param orderType
	 * @param orderCondition
	 * @param orderAmount
	 * @param orderUnitPrice
	 * @return
	 */
	private boolean validateInputs(String orderType, String orderCondition,
			String orderAmount, String orderUnitPrice){

		if(orderType == null || orderCondition == null
				|| orderAmount == null || orderUnitPrice == null)
			return false;

		try{
			int amount = Integer.parseInt(orderAmount);
			int unitPrice = Integer.parseInt(orderUnitPrice);

			if(amount * unitPrice > 30000000){
				return false;
			} else {
				return true;
			}

		} catch (NumberFormatException e){
			return false;
		}
	}
}
