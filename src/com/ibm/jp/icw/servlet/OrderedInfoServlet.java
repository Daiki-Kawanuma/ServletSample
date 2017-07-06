package com.ibm.jp.icw.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.dao.OrderDao;
import com.ibm.jp.icw.model.Order;
import com.ibm.jp.icw.model.User;

/**
 * Servlet implementation class OrderedInfoServlet
 */
@WebServlet("/OrderedInfoServlet")
public class OrderedInfoServlet extends BaseServlet {
	// 色々定義しときます
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderedInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionConstants.PARAM_USER);

		ArrayList<Order> orderList = OrderDao.getOrderList(user.getAccountNumber());
		int size = orderList.size();

		if(size == 0){
			request.setAttribute("message", "注文情報がありません。");
		}

		request.setAttribute("orderList",orderList );

		request.getRequestDispatcher("orderdinfo.jsp").forward(request, response);




	}

}
