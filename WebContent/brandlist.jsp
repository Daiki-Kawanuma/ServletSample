<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@page import="com.ibm.jp.icw.model.Brand"%>
<%@page import="com.ibm.jp.icw.dao.BrandDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page import="com.ibm.jp.icw.model.User"%>
<%@ page import="java.text.NumberFormat;"%>
<%
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>銘柄検索一覧｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
<style>
.tablebrandlist {
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
	<h2>銘柄を検索</h2>
	<form action="search" method="POST">
		<!-- 	検索条件を入力してください：<br><br> -->
		<!-- 	<select name="searchtype" style="font-size:72pt"> -->
		<input type="hidden" name="current_page" value="brandlist"> <input
			type="radio" name="searchtype" value="brandcode">銘柄コード(４桁)から検索<br>
		<input type="radio" name="searchtype" value="brandname">銘柄名から検索<br>
		<br> <input type="text" name="searchcondition"> <input
			class="square_btn" type="submit" value="検索" style="font-size: 20pt" />
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
			<td
				style="color: <%=brand.getBrandStatus().equals("正常銘柄") ? "black" : "red"%>;"><%=brand.getBrandStatus().equals("正常銘柄") ? brand.getBrandName()
						: "【" + brand.getBrandStatus() + "】" + brand.getBrandName()%></td>
			<td><%=brand.getMarket()%></td>
			<td><%=brand.getIndustry()%></td>
			<td align="center"><%=brand.getTradingUnit()%></td>
			<td align="right"><%= NumberFormat.getNumberInstance().format(brand.getMarketPrice()) %> 円</td>
			<td align="center"><form action="search" method="POST">
					<input type="hidden" name="current_page" value="brandlist">
					<button class="square_btn" type="submit" name="detail"
						value="<%=brand.getBrandCode()%>"
						style="width: 100%; height: 100%; font-size: 100%">詳細閲覧</button>
					<button class="square_btn" type="submit" name="order"
						value="<%=brand.getBrandCode()%>"
						style="width: 100%; height: 100%; font-size: 100%">買い注文</button>
				</form></td>
			<%
				}
			%>

	</table>
	<br>
</body>
</html>