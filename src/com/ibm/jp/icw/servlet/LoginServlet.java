package com.ibm.jp.icw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		String account_number = request.getParameter("account_number");
		String login_pass = request.getParameter("login_pass");

		//User user = UserDao.getUser("account_number");

		//if (login_pass.equals(user.getPassword())) {
		if (login_pass.equals("AAA")){
			//session.setAttribute(SessionConstants.PARAM_USER,user);
		} else {
			//response.sendRedirect("login.jsp");
			request.setAttribute("message","エラーメッセージ:正しいアカウントナンバー・ログインパスワードを入力してください。");
			RequestDispatcher message = request.getRequestDispatcher("/login.jsp");
			message.forward(request, response);



					//System.out.println("エラーメッセージ:正しいアカウントナンバー・ログインパスワードを入力してください。");
		}
	}

}
