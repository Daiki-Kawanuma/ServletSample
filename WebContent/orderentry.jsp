<%@page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ibm.jp.icw.model.Brand" %>
<%
    request.setCharacterEncoding("UTF-8");
    Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);
	String message = (String)request.getAttribute("message");
	if(message==null){
		message="";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>買い注文｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
<style type="text/css">
table, td {
	border-style: solid;
	border-width: 1px;
	border-color: black;
}
</style>
</head>
<body>
	<h1>買い注文</h1>
	<h2><%= brand.getBrandName() %></h2>
	<form action="order" method="POST">
		<input type="hidden" name="current_page" value="orderentry">
		<h3>注文の種類</h3>
		<input type="radio" name="order_type" value="成行">成行<br>
		<input type="radio" name="order_type" value="指値">指値<br>
		<br>
		<h3>執行条件</h3>
		<input type="radio" name=order_condition value="無条件">無条件<br>
		<input type="radio" name=order_condition value="寄付">寄付<br>
		<input type="radio" name=order_condition value="引け">引け<br>
		<input type="radio" name=order_condition value="指成">指成<br>
		<h3>注文数</h3>
		<input type="text" name="order_amount"><br>
		<h3>注文単価</h3>
		<input type="text" name="order_unit_price"><br>
		<input type="submit" value="注文確認へ進む" style="font-size: 20pt" />
	</form>
	<p><font color="red"><%=message %></p>
</body>
</html>