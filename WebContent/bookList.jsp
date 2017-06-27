<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ibm.jp.icw.dto.BookDTO" %>

<% ArrayList<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ICW動作確認サンプル</title>
<style type="text/css">
	table,td {
		border-style: solid;
		border-width: 1px;
		border-color: black;
	}
</style>
</head>
<body>
	<h1>登録本一覧</h1>
	<table >
		<tr>
			<td>本の名前</td>
			<td>著者</td>
			<td>価格（円）</td>
		</tr>
		<% for (BookDTO book: list) { %>
		<tr>
			<td><%= book.getName() %></td>
			<td><%= book.getAuthor() %></td>
			<td><%= book.getPrice() %></td>
		</tr>
		<% } %>
	</table>
	<br>
	<a href="./">検索ページに戻る</a>
</body>
</html>