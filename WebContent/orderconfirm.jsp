<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.ibm.jp.icw.model.Order"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants" %>
<%
	request.setCharacterEncoding("UTF-8");
	Order order = (Order) request.getAttribute(SessionConstants.PARAM_ORDER);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文内容確認｜TS長谷川証券</title>
<style type="text/css">
table, td {
	border-style: solid;
	border-width: 1px;
	border-color: black;
}
</style>
</head>
<body>
	<h1>ご注文内容の確認</h1>
	<br>
	<table>
		<tr>
			<th>三菱電気</th>
		</tr>
		<tr>
			<td>銘柄コード</td>
			<td><%= order.getBrand().getBrandCode() %></td>
		</tr>
		<tr>
			<td>銘柄名</td>
			<td><%= order.getBrand().getBrandName() %></td>
		</tr>
		<tr>
			<td>注文の種類</td>
			<td><%= order.getOrderKind().toString() %></td>
		</tr>
		<tr>
			<td>執行条件</td>
			<td><%= order.getOrderConditions().toString() %></td>
		</tr>
		<tr>
			<td>注文単価</td>
			<td><%= order.getOrderUnitPrice() %></td>
		</tr>
		<tr>
			<td>注文数</td>
			<td><%= order.getOrderAmount() %></td>
		</tr>
		<tr>
			<td>注文金額合計</td>
			<td><%= order.getOrderUnitPrice() * order.getOrderAmount() %></td>
		</tr>
	</table>
	<br>
	<form action="order" method="POST">
		<input type="hidden" name="current_page" value="orderconfirm">
		<input type="submit" value="注文確認へ進む" style="font-size: 20pt" />
	</form>
	<br>
</body>
</html>