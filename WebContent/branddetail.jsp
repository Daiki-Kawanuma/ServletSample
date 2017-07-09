<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ibm.jp.icw.model.Brand"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page import="com.ibm.jp.icw.model.User"%>
<%
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
	request.setCharacterEncoding("UTF-8");
	Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);
	String brandStatus = brand.getBrandStatus().equals("正常銘柄") ? "" : "【" + brand.getBrandStatus() + "】";
	String color = brand.getBrandStatus().equals("正常銘柄") ? "black" : "red";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>銘柄詳細｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
<style>
.tablebrandlist {
	border-style: solid;
	border-width: 0px;
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
	<h2 style="color: <%= color %>;"><%= brandStatus + brand.getBrandName()%> 詳細情報
	</h2>

	<br>
	<br>
	<table class="tablebrandlist" border=1>
		<tr style="color: #FFFFFF">
			<th>銘柄コード</th>
			<th>銘柄名</th>
			<th>市場</th>
			<th>業種</th>
			<th>売買単位</th>
		</tr>
		<tr>
			<td><%=brand.getBrandCode()%></td>
			<td><%=brand.getBrandName()%></td>
			<td><%=brand.getMarket()%></td>
			<td><%=brand.getIndustry()%></td>
			<td><%=brand.getTradingUnit()%></td>
			<td><%=brand.getBidPrice()%></td>
			<td><%=brand.getOfferPrice()%></td>


		</tr>
		<tr style="color: #FFFFFF">
			<th>株価</th>
			<th>始値</th>
			<th>終値</th>
			<th>高値</th>
			<th>安値</th>
			<th>年初来高値</th>
			<th>年初来安値</th>
			<th>買い気配値</th>
			<th>売り気配値</th>
		</tr>
		<tr>
			<td><%=brand.getMarketPrice()%></td>
			<td><%=brand.getOpeningPrice()%></td>
			<td><%=brand.getClosePrice()%></td>
			<td><%=brand.getHighPrice()%></td>
			<td><%=brand.getLowPrice()%></td>
			<td><%=brand.getYearToDateHighs() %></td>
			<td><%=brand.getYearToDateLows()%></td>
		</tr>
	</table>
	<br>
	<br>
	<form action="order" method="POST">
		<input type="hidden" name="current_page" value="branddetail">
		<input class="square_btn" type="submit" value="注文へ進む" style="font-size: 20pt" />
	</form>
</body>
</html>