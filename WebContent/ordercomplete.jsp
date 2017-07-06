<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ibm.jp.icw.model.Order"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%
	request.setCharacterEncoding("UTF-8");
	Order order = (Order) request.getAttribute(SessionConstants.PARAM_ORDER);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文内容確認｜TS長谷川証券</title>
</head>
<body>
	<h1>ご注文完了</h1>
	<h2>
		注文番号<%=order.getReceptionNumber()%>で承りました。
	</h2>
	<h2>またご注文をお待ちしております。</h2>
	<br>
	<br>
	<form action="mypage.jsp" method="GET">
		<input type="submit" value="マイページに戻る" style="font-size: 20pt" />
	</form>
</body>
</html>