<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.ibm.jp.icw.model.Order"%>
<%@ page import="com.ibm.jp.icw.model.User"%>
<%@ page import="com.ibm.jp.icw.model.Brand"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants" %>
<%@ page import="java.text.NumberFormat;"%>
<%
	request.setCharacterEncoding("UTF-8");
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);

	Order order = (Order) session.getAttribute(SessionConstants.PARAM_ORDER);
	String buyOrSell = order.getTradingType().equals("B") ? "買い注文" : "売り注文";

	Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);
	String brandStatus = brand.getBrandStatus().equals("正常銘柄") ? "" : "【" + brand.getBrandStatus() + "】";
	String color = brand.getBrandStatus().equals("正常銘柄") ? "black" : "red";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文内容確認｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
<style type="text/css">
.tableOrder {
	font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,
		Osaka, 'MS PGothic', arial, helvetica, sans-serif;
	border-style: solid;
	border-width: 0px;
	border-color: black;
}

.tableOrder th {
	color: "#FFF";
	width: 50%;
	background-color: #999999;
}

.tableOrder td {
	width: 50%;
	height: 50px;
}
</style>
</head>
<body>
	<!-- ヘッダー部分 -->
	<div style="overflow: auto; background-color: #009999">
		<div style="float: left;">
			<h1>
				長谷川証券<br>トレーディングシステム
			</h1>
		</div>
		<div style="float: right;">
			<p style="color: white; font-size: 120%; margin: 0px 10px 0px 0px"><%=user.getName()%>さん
			</p>
			<input class="square_btn"
				style="width: 125px; margin: 8px 10px 0px 0px; font-size: 100%"
				type="button" onClick="location.href='mypage.jsp'" value="マイページ">
			<br> <input class="square_btn"
				style="width: 125px; margin: 8px 10px 10px 0px; font-size: 100%;"
				type="button" onClick="location.href='logout'" value="ログアウト">
		</div>
	</div>
	<!-- ヘッダー部分 -->
	<h2>ご注文内容の確認</h2>
	<br>
	<table class="tableOrder" border="1">
		<tr>
		</tr>
		<tr>
			<th style="color: white;">銘柄コード</th>
			<td><%= order.getBrand().getBrandCode() %></td>
		</tr>
		<tr>
			<th style="color: white;">銘柄名</th>
			<td style="color: <%= color %>;"><%= brandStatus + brand.getBrandName()%></td>
		</tr>
		<tr>
			<th style="color: white;">売買区分</th>
			<td><%= buyOrSell %></td>
		</tr>
		<tr>
			<th style="color: white;">注文の種類</th>
			<td><%= order.getOrderType().toString() %></td>
		</tr>
		<tr>
			<th style="color: white;">執行条件</th>
			<td><%= order.getOrderConditions().toString() %></td>
		</tr>
		<tr>
			<th style="color: white;">注文単価</th>
			<td><%= (int) order.getOrderUnitPrice() == 0 ? "ー" : NumberFormat.getNumberInstance().format(order.getOrderUnitPrice()) + " 円" %></td>
		</tr>
		<tr>
			<th style="color: white;">注文数</th>
			<td><%= order.getOrderAmount() %></td>
		</tr>
		<tr>
			<th style="color: white;">注文金額合計</th>
			<td><%= (int) order.getOrderUnitPrice() == 0 ? "ー" : NumberFormat.getNumberInstance().format(order.getOrderUnitPrice() * order.getOrderAmount() ) + "円" %></td>
		</tr>
	</table>
	<br>
	<br>
	<form action="order" method="POST">
		<input type="hidden" name="current_page" value="orderconfirm">
		<input class="square_btn" type="submit" value="注文を確定する" style="font-size: 20pt" />
	</form>
	<br>
</body>
</html>