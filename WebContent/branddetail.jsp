<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>銘柄詳細｜TS長谷川証券</title>
<style type="text/css">
	table,td {
		border-style: solid;
		border-width: 1px;
		border-color: black;
	}
</style>
</head>
<body>
<!-- 	<h1>詳細情報</h1> -->
<br><br>
<button type="button" onclick="alert('買い注文画面に遷移しますが宜しいですか？')">買い注文</button><br><br>

<table class="table2" border=1>
 <tr><td>銘柄コード</td>
 <tr><td>銘柄名</td>
 <tr><td>業種</td>
 <tr><td>売買単位</td>
 <tr><td>株価</td>
 <tr><td>始値</td>
 <tr><td>高値</td>
 <tr><td>安値</td>
 <tr><td>売り気配値</td>
 <tr><td>買い気配値</td>
 <tr><td>年初来高値</td>
 <tr><td>年初来安値</td>
</table><br><br>

	<br>
	<a href="orderentry.jsp/">買い注文をする</a>
</body>
</html>