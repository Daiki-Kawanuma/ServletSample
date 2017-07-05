<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    request.setCharacterEncoding("UTF-8");
    Order order = (Order) session.getAttribute(SessionConstants.PARAM_BRAND);
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文状況一覧</title>
</head>
<body>
	<h1>注文状況一覧</h1>
	<table border=1>
		<%for (Order o: orderList){ %>

		<tr><th>受付番号</th><th>銘柄名</th><th>銘柄コード</th><th>現在値</th></tr>
		<tr><td><%=o.getReceptionNumber() %></td><td><%=o.getBrand() %></td><td><%= %></td><td><%=o.getBrand().getMarket() %> %></td></tr>
		<tr><th>注文状況</th><th>売買区分</th><th>注文の種類</th><th>執行条件</th></tr>
		<tr><td><%=o.getOrderConditions() %></td><td><%=o.getTradingType() %></td><td><%=o.getOrderKind() %></td><td><%= %></td></tr>
		<tr><th>注文日時</th><th>注文数</th><th>注文単価</th><th>注文合計金額</th></tr>
		<tr><td><%=o.getOrderDate() %></td><td><%=o.getOrderAmount() %></td><td><%=o.getOrderUnitPrice() %></td><td><%= %></td></tr>
		<tr><th>成約日時</th><th>成約数</th><th>成約単価</th><th>成約合計金額</th></tr>
		<tr><td><%=o.getClosingDate() %></td><td><%= %></td><td><%=o.getClosingUnitPrice() %></td><td><%= %></td></tr>
		<% }%>
	</table>


</body>
</html>