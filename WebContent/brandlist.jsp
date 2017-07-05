<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>銘柄検索結果｜TS長谷川証券</title>
<style type="text/css">
	table,td {
		border-style: solid;
		border-width: 1px;
		border-color: black;
	}
</style>
</head>
<body>
<h1>銘柄を検索</h1>
<form action="questionnaire" method="POST">
<!-- 	検索条件を入力してください：<br><br> -->
<!-- 	<select name="searchtype" style="font-size:72pt"> -->
	<input type="radio" name="searchtype" value="brandcode">銘柄コード(４桁)から検索<br>
	<input type="radio" name="searchtype" value="brandname">銘柄名から検索<br><br>

<!-- 検索ボタンを大きくしたい

例えば

.button{
height:30px;
width:100px;
}

とCSSで設定したら

html部分には

<input type="submit" value="検索" class="button">

と書けばよいだけだった。 -->



	<input type="text" name="searchcondition">
	<input type="submit" value="検索"style="font-size:20pt"/>
	</form><br><br>



<!-- <h1>検索結果一覧</h1> -->
	<table >
		<tr>
			<td>銘柄コード</td>
			<td>銘柄名</td>
			<td>市場</td>
			<td>業種</td>
			<td>売買単位</td>
			<td>株価</td>
			<td>始値</td>
			<td>高値</td>
			<td>安値</td>
			<td>アクション</td>
		</tr>
		<%-- <% for (BrandDAO brand: list) { %>
		<tr>
			<td><%= brand.getCode() %></td>
			<td><%= brand.getName() %></td>
			<td><%= brand.getMarket() %></td>
			<td><%= brand.getIndustry() %></td>
			<td><%= brand.getUnit() %></td>
			<td><%= brand.getDetail() %></td>
			<td><%= brand.getFairValue() %></td>
		</tr>
		<% } %> --%>
	</table>
	<br>
</body>
</html>