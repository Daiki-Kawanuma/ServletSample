package com.ibm.jp.icw.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.icw.constant.SessionConstants;
import com.ibm.jp.icw.model.Brand;
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

		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionConstants.PARAM_USER);

		Brand.getBrand("jh");






	}
}
