<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ibm.jp.icw.model.Brand"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%
	request.setCharacterEncoding("UTF-8");
	Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>銘柄詳細｜TS長谷川証券</title>
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
	<br>
	<br>
	<table class="table2" border=1>
		<tr>
			<th>銘柄コード</th>
			<th>銘柄名</th>
			<th>市場</th>
			<th>業種</th>
			<th>売買単位</th>
			<th>株価</th>
			<th>始値</th>
			<th>高値</th>
			<th>安値</th>
			<th>アクション</th>
		</tr>
		<tr>
			<td><%=brand.getBrandCode()%></td>
			<td><%=brand.getBrandName()%></td>
			<td><%=brand.getMarket()%></td>
			<td><%=brand.getIndustry()%></td>
			<td><%=brand.getTradingUnit()%></td>
			<td><%=brand.getMarketPrice()%></td>
			<td><%=brand.getOpeningPrice()%></td>
			<td><%=brand.getHighPrice()%></td>
			<td><%=brand.getLowPrice()%></td>
	</table>
	<br>
	<br>
	<form action="order" method="POST">
		<input type="hidden" name="current_page" value="branddetail">
		<input type="submit" value="注文へ進む" style="font-size: 20pt" />
	</form>
</body>
</html>