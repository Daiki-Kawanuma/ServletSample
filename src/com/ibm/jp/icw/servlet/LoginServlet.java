package com.ibm.jp.icw.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String accountNumber = request.getParameter("account_number");
		String loginPass = request.getParameter("login_pass");

		//*
		User user = new User("1234123412341234", "Kawanuma", "password", "customer@example.com", new Date(),
				12345678, "1234123412341234", "DAIKI KAWANUM", "123", new Date());
		/*/
		User user = UserDao.getUser(accountNumber);
		//*/

		if (checkPass(loginPass, user.getPassword())){
			session.setAttribute(SessionConstants.PARAM_USER, user);
			response.sendRedirect("mypage");
		} else {
			request.setAttribute("message", "エラーメッセージ:正しいアカウントナンバー・ログインパスワードを入力してください。");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public boolean checkPass(String input, String loginPass){

		if(input == null || loginPass == null)
			return false;

		if(loginPass.equals(input)){
			return true;
		} else {
			return false;
		}
	}
}
