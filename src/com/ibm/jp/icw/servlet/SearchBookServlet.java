package com.ibm.jp.icw.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.icw.dto.BookDTO;
import com.ibm.jp.icw.service.SearchBookService;

/**
 * サンプル用のサーブレット。
 */
public class SearchBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("情報：SearchBookServlet#doGet 開始");
		System.out.println("情報：SearchBookServlet#index.jspへforward");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("情報：SearchBookServlet#doPost 開始");

		String userid = (String) req.getParameter("userid");
		System.out.println("情報：SearchBookServlet#reqのパラメータ：userid：" + userid);

		System.out.println("情報：SearchBookServlet#書籍リストを取得");
		ArrayList<BookDTO> list = SearchBookService.searchBook(userid);

		if (list == null) {
			System.out.println("警告：SearchBookServlet#書籍リストがnull");
			req.setAttribute("errormessage", "userid(" + userid + ")はユーザーとして登録されていません。");
			System.out.println("警告：SearchBookServlet#エラーメッセージとともに、index.jspへforward");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			System.out.println("情報：SearchBookServlet#書籍リストをbookList.jspへforward");
			req.setAttribute("list",list);
			req.getRequestDispatcher("bookList.jsp").forward(req, resp);
		}
	}
}
