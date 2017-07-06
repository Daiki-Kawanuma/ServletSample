<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@page import="com.ibm.jp.icw.model.Brand"%>
<%@page import="com.ibm.jp.icw.dao.BrandDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>銘柄検索結果｜TS長谷川証券</title>
<style type="text/css">
table, td {
	border-style: solid;
	border-width: 1px;
	border-color: black;
}
</style>
</head>
<body>
	<h1>銘柄を検索</h1>
	<form action="search" method="POST">
		<!-- 	検索条件を入力してください：<br><br> -->
		<!-- 	<select name="searchtype" style="font-size:72pt"> -->
		<input type="radio" name="searchtype" value="brandcode">銘柄コード(４桁)から検索<br>
		<input type="radio" name="searchtype" value="brandname">銘柄名から検索<br>
		<br> <input type="text" name="searchcondition"> <input
			type="submit" value="検索" style="font-size: 20pt" />
	</form>
	<br>
	<br>

	<%
		ArrayList<Brand> list = (ArrayList<Brand>) request.getAttribute("brandList");
	%>

	<!-- <h1>検索結果一覧</h1> -->
	<table border=1>
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
		<%
			for (Brand brand : list) {
		%>
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
			<td><form action="search" method="POST">
					<input type="hidden" name="current_page" value="brandlist">
					<button type="submit" name="detail"
						value="<%=brand.getBrandCode()%>">詳細閲覧</button>
					<button type="submit" name="order"
						value="<%=brand.getBrandCode()%>">買い注文</button>
				</form></td>
			<%
				}
			%>

	</table>
	<br>
</body>
</html>