<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ibm.jp.icw.model.Order" %>

<%
    request.setCharacterEncoding("UTF-8");
 	ArrayList<Order> orderlist = (ArrayList<Order>)request.getAttribute("orderlist");
 	String message = (String)request.getAttribute("message");
	if(message == null){
		message = "";
	}
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文状況一覧</title>
</head>
<body>
	<h1>注文状況一覧</h1>
	<p><%=message%></p>
	<%for (Order o: orderlist){ %>
	<form method="POST" action="BrandInfoServlet">
	<table border=1>
		<tr><th>受付番号</th><th>銘柄名</th><th>銘柄コード</th><th>現在値</th></tr>
		<tr><td><%=o.getReceptionNumber() %></td><td><%=o.getOrderStatus() + o.getBrand().getBrandName() %></td><td><%=o.getBrand().getBrandCode() %></td><td><%=o.getBrand().getMarketPrice() %></td></tr>
		<tr><th>注文状況</th><th>売買区分</th><th>注文の種類</th><th>執行条件</th></tr>
		<tr><td><%=o.getOrderStatus() %></td><td><%=o.getTradingType() %></td><td><%=o.getOrderKind() %></td><td><%=o.getOrderConditions() %></td></tr>
		<tr><th>注文日時</th><th>注文数</th><th>注文単価</th><th>注文合計金額</th></tr>
		<tr><td><%=o.getOrderDate() %></td><td><%=o.getOrderAmount() %></td><td><%=o.getOrderUnitPrice() %></td><td><%=o.getOrderAmount() * o.getOrderUnitPrice()%></td></tr>
		<tr><th>成約日時</th><th>成約数</th><th>成約単価</th><th>成約合計金額</th></tr>
		<tr><td><%=o.getClosingDate() %></td><td><%=o.getClosingAmount() %></td><td><%=o.getClosingUnitPrice() %></td><td><%=o.getClosingAmount() * o.getClosingUnitPrice()%></td></tr>

	</table>
	<input type="submit" value="銘柄詳細情報を表示する">
	</form>
	<%}%>
	<p><a href="maypage.jsp">戻る</a></p>

</body>
</html>