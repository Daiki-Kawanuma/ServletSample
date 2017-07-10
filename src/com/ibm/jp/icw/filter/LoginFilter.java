package com.ibm.jp.icw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.icw.constant.SessionConstants;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession(false);
		String logoutUrl = servletRequest.getContextPath() + "/logout";
		String forcedLogoutUrl = servletRequest.getContextPath() + "/forcedlogout.jsp";
		String loginUrl = servletRequest.getContextPath() + "/login";
		String headerUrl = servletRequest.getContextPath() + "/Header.css";

		boolean isLogin = session != null && session.getAttribute(SessionConstants.PARAM_USER) != null;

		if (isLogin) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			if (servletRequest.getRequestURI().equals(logoutUrl)
					|| servletRequest.getRequestURI().equals(forcedLogoutUrl)
					|| servletRequest.getRequestURI().equals(loginUrl)
					|| servletRequest.getRequestURI().equals(headerUrl)) {
				chain.doFilter(servletRequest, servletResponse);
			} else {

			     if (session == null){
				        System.out.println("セッションは破棄されました");
				      }else{
				        System.out.println("セッションが残っています");
				      }//統合テスト用

				servletResponse.sendRedirect(forcedLogoutUrl);
			}
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
}
