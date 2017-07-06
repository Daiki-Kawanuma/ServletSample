<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.ibm.jp.icw.model.User"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%
	request.setCharacterEncoding("UTF-8");
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マイページ｜TS長谷川証券</title>
</head>
<body>
	<header id="hasegawa"> <nav>
	<ul>
		<h1>長谷川証券トレーディングシステム</h1>
		<li><a href="logout.jsp">ログアウト</a></li>
		<li><a href="mypage.jsp">マイページ</a></li>
		<hr>
	</ul>
	</nav> </header>
	<h2>マイページ</h2>
	<br>
	<p>
		ようこそ
		<%=user.getName()%>
		さん
	</p>
	<br>

	<input type="button" onClick="location.href='brandsearch.jsp'"
		value="銘柄を検索/買い注文する">
	<br>
	<br>
	<input type="button" onClick="location.href='orderdinfo.jsp'"
		value="注文状況を確認する">

</body>
</html>