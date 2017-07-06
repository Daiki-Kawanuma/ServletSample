<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文内容確認｜TS長谷川証券</title>
<style type="text/css">
table, td {
	border-style: solid;
	border-width: 1px;
	border-color: black;
}
</style>
</head>
<body>
	<h1>ご注文内容の確認</h1>
<br>
<table>
 <tr><th>三菱電気</th></tr>
 <tr><td>銘柄コード</td><td>1234</td></tr>
 <tr><td>銘柄名</td><td>三菱電気</td></tr>
 <tr><td>注文の種類</td><td>指値</td></tr>
 <tr><td>執行条件</td><td>指成</td></tr>
 <tr><td>注文単価</td><td>125</td></tr>
  <tr><td>注文数</td><td>1200</td></tr>
</table>
<br>



 	<%--
		<% for (OrderDao brand: list) { %>
		<tr>
			<td><%= brand.getCode() %></td>
			<td><%= brand.getName() %></td>
			<td><%= brand.getOrderType() %></td>
			<td><%= brand.getOrderCondition() %></td>
			<td><%= brand.getOrderPrice() %></td>
			<td><%= brand.getOrderAmount() %></td>
		</tr>
		<% } %>
	 --%>

<button type="button" onclick="alert('買い注文を実行します')">確認</button><br><br>

</body>
</html>