package com.ibm.jp.icw.servlet;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.icw.constant.ServletConstants;
import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.model.Brand;
import com.ibm.jp.icw.model.Order;
import com.ibm.jp.icw.model.User;

//package com.ibm.jp.icw.servlet;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.ibm.jp.icw.dto.BookDTO;
//import com.ibm.jp.icw.service.SearchBookService;


public class BrandInfoServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
		Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);

//		String currentPage = (String) request.getAttribute(PARAM_CURRENT_PAGE);
//		String nextPage = null;

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
}
