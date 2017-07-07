package com.ibm.jp.icw.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public abstract class BaseServlet extends HttpServlet implements HttpSessionBindingListener {

	/** セッション開始時の処理 **/
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("valueBound");
	}

	/** セッション終了時の処理 **/
	public void valueUnbound(HttpSessionBindingEvent event) {

	}
}
