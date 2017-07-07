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
@WebServlet("/order")
public class OrderServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private static final String PARAM_CURRENT_PAGE = "current_page";
	private static final String PARAM_ORDER_TYPE = "order_type";
	private static final String PARAM_ORDER_CONDITION = "order_condition";
	private static final String PARAM_ORDER_AMOUNT = "order_amount";
	private static final String PARAM_ORDER_UNIT_PRICE = "order_unit_price";
	private static final String PARAM_ERROR_MESSAGE = "error_message";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
		Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);

		Order order = (Order) session.getAttribute(SessionConstants.PARAM_ORDER);

		String currentPage = request.getParameter(PARAM_CURRENT_PAGE);
		if(currentPage == null)
			currentPage = ServletConstants.BRAND_LIST;
		String nextPage = null;

		switch (currentPage) {
		case ServletConstants.BRAND_LIST:
		case ServletConstants.BRAND_DETAIL:
			request.getSession().setAttribute(SessionConstants.PARAM_BRAND, brand);
			nextPage = ServletConstants.ORDER_ENTRY + ".jsp";
			break;
		case ServletConstants.ORDER_ENTRY:

			String orderType = request.getParameter(PARAM_ORDER_TYPE);
			String orderCondition = request.getParameter(PARAM_ORDER_CONDITION);
			String orderAmout  = request.getParameter(PARAM_ORDER_AMOUNT);
			String orderUnitPrice = request.getParameter(PARAM_ORDER_UNIT_PRICE);

			if(validateInputs(orderType, orderCondition, orderAmout,orderUnitPrice)){

				nextPage = ServletConstants.ORDER_CONFIRM + ".jsp";

				order = new Order(brand, user, Order.OrderType.getEnum(orderType),
						Order.OrderCondition.getEnum(orderCondition),
						Integer.parseInt(orderAmout), Integer.parseInt(orderUnitPrice), new Date());

				session.setAttribute(SessionConstants.PARAM_ORDER, order);

			} else {

				nextPage = ServletConstants.ORDER_ENTRY + ".jsp";
			}
			break;
		case ServletConstants.ORDER_CONFIRM:

			//* Debug
			order.setReceptionNumber(123456789);
			Order registeredOrder = order;
			/*/
			Order registeredOrder = OrderDao.registOrder(order);
			//*/

			if(registeredOrder != null){
				nextPage = ServletConstants.ORDER_COMPLETE + ".jsp";
				session.removeAttribute(SessionConstants.PARAM_ORDER);
				request.setAttribute(SessionConstants.PARAM_RECEPTION_NUMBER, order.getReceptionNumber());
			} else {
				// TODO Orderが登録できなかった場合
			}
			break;
		case ServletConstants.ORDER_COMPLETE:
			nextPage = ServletConstants.MY_PAGE;
			break;
		default:
			nextPage = ServletConstants.ORDER_ENTRY + ".jsp";
			break;
		}
		request.getRequestDispatcher("/" + nextPage).forward(request, response);
	}

	/**
	 *
	 * @param orderType
	 * @param orderCondition
	 * @param orderAmount
	 * @param orderUnitPrice
	 * @return
	 */
	public boolean validateInputs(String orderType, String orderCondition,
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
