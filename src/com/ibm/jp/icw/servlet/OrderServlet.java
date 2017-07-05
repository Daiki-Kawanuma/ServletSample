package com.ibm.jp.icw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.icw.constant.ServletConstants;
import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.model.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute(SessionConstants.PARAM_USER);

		String currentPage = request.getParameter(ServletConstants.ORDER_ENTRY);
		String nextPage = null;

		switch (currentPage) {
		case ServletConstants.ORDER_ENTRY:
			nextPage = ServletConstants.ORDER_ENTRY + ".jsp";
			break;
		case ServletConstants.ORDER_CONFIRM:
			nextPage = ServletConstants.ORDER_CONFIRM + ".jsp";
			break;
		case ServletConstants.ORDER_COMPLETE:

			break;
		default:
			break;
		}

		response.sendRedirect(nextPage);
	}

}
