<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@page import="com.ibm.jp.icw.model.Brand"%>
<%@page import="com.ibm.jp.icw.dao.BrandDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page import="com.ibm.jp.icw.model.User"%>
<%@ page import="java.text.NumberFormat"%>
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
		width: 700px;
	height: 70px;

}

.tablebrandlist td {
	width: 700px;
	height: 70px;
}

h2 {
	color: #444;
	position: relative;
	padding: 0.6em;
	background: #e0edff;
	font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,
		Osaka, 'MS PGothic', arial, helvetica, sans-serif;
}

h2:after {
	position: absolute;
	content: '';
	top: 100%;
	left: 30px;
	border: 15px solid transparent;
	border-top: 15px solid #e0edff;
	width: 0;
	height: 0;
}


</style>
</head>
<body>
	<!-- ヘッダー部分 -->
	<div style="overflow: auto; background-color: #009999;background-clip:border-box;height: 135px;border: solid 0.4em transparent;">
		<div style="float: left;">
			<h1>
				長谷川証券<br>トレーディングシステム
			</h1>
		</div>
		<div style="float: right;font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">
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
		<input type="hidden" name="current_page" value="brandlist">
		<p style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">1. 検索方法を選択してください。</p>
		<br>
		<div style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">
		<input type="radio" name="searchtype" value="brandcode" style="width:50px;height:50px;vertical-align:middle;">銘柄コード(４桁)から検索<br>
		<input type="radio" name="searchtype" value="brandname" style="width:50px;height:50px;vertical-align:middle;">銘柄名から検索<br>
		</div>
		<br>
		<p style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">2. 銘柄コード(４桁)または銘柄名を入力してください。</p>
		<br> <input type="text" name="searchcondition"> <input
			class="square_btn" type="submit" value="検索" style="font-size: 20pt" />
	</form>
	<br>
	<br>

	<%
		ArrayList<Brand> list = (ArrayList<Brand>) request.getAttribute("brandList");
	%>

	<!-- <h1>検索結果一覧</h1> -->
	<div style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">
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
			<td align="right"><%=NumberFormat.getNumberInstance().format(brand.getMarketPrice())%>
				円</td>
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
	</div>
	<br>
</body>
</html>