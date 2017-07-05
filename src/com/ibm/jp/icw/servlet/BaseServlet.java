package com.ibm.jp.icw.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	public void doLogout(HttpServletRequest request, HttpServletResponse response){

		try{
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
		} catch(Exception e){
			System.err.println("エラー：BaseServlet#ログアウト失敗");
			e.printStackTrace();
		}
	}
}
