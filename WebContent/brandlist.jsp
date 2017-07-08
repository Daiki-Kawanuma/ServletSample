<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@page import="com.ibm.jp.icw.model.Brand"%>
<%@page import="com.ibm.jp.icw.dao.BrandDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
<
meta http-equiv ="Content-Type" content ="text/html; charset =UTF-8"> <title>銘柄検索結果｜TS長谷川証券
	</title> <link rel ="stylesheet" href ="Header.css " type ="text/html">.tablebrandlist
	{
	border-style: solid;
	border-width: 1px;
	border-color: black;
}

.tablebrandlist th {
	background-color: #999999;
}

.tablebrandlist td {
	width: 700px;
	height: 70px;
}
</style>
</head>
<body>
	<h2>銘柄を検索</h2>
	<form action="search" method="POST">
		<!-- 	検索条件を入力してください：<br><br> -->
		<!-- 	<select name="searchtype" style="font-size:72pt"> -->
		<input type="hidden" name="current_page" value="brandlist"> <input
			type="radio" name="searchtype" value="brandcode">銘柄コード(４桁)から検索<br>
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
	<table class="tablebrandlist" border=1>
		<tr style="color: #FFFFFF">
			<th>銘柄コード</th>
			<th>銘柄名</th>
			<th>市場</th>
			<th>業種</th>
			<th>売買単位</th>
			<th>株価</th>
			<th>アクション</th>
		</tr>
		<%
			for (Brand brand : list) {
		%>
		<tr>
			<td align="center"><%=brand.getBrandCode()%></td>
			<td><%=brand.getBrandName()%></td>
			<td><%=brand.getMarket()%></td>
			<td><%=brand.getIndustry()%></td>
			<td align="center"><%=brand.getTradingUnit()%></td>
			<td align="right"><%=brand.getMarketPrice()%></td>
			<td align="center"><form action="search" method="POST">
					<input type="hidden" name="current_page" value="brandlist">
					<br>
					<button type="submit" name="detail"
						value="<%=brand.getBrandCode()%>"
						style="width: 100px; height: 30px">詳細閲覧</button>
					<br>
					<br>
					<button type="submit" name="order"
						value="<%=brand.getBrandCode()%>"
						style="width: 100px; height: 30px">買い注文</button>
					<br>
				</form></td>
			<%
				}
			%>

	</table>
	<br>
</body>
</html>