<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.jp.icw.model.Order"%>

<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderlist");
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
%>
<html>
<head>
<style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文状況一覧</title>
<link rel="stylesheet" href="Header.css" type="text/html">
.tablechumonjokyo {
	border-style: solid;
	border-width: 1px;
	border-color: black;
	}
.tablechumonjokyo th {
  background-color: #999999;
}

</style>



</head>
<body>
	<h1>注文状況一覧</h1>
	<p><%=message%></p>
	<form method="POST" action="search">
		<table class="tablechumonjokyo" border=1>
			<tr style="color:#FFFFFF">
				<th>受付番号</th>
				<th>銘柄名</th>
				<th>銘柄コード</th>
				<th>現在値</th>

				<th>注文状況</th>
				<th>売買区分</th>
				<th>注文の種類</th>
				<th>執行条件</th>

				<th>注文日時</th>
				<th>注文数</th>
				<th>注文単価</th>
				<th>注文合計金額</th>

				<th>成約日時</th>
				<th>成約数</th>
				<th>成約単価</th>
				<th>成約合計金額</th>
				<th>銘柄詳細</th>
			</tr>
			<%
				for (Order o : orderList) {
			%>
			<tr>
				<td><%=o.getReceptionNumber()%></td>
				<td><%=o.getBrand().getBrandStatus() + o.getBrand().getBrandName()%></td>
				<td><%=o.getBrand().getBrandCode()%></td>
				<td><%=o.getBrand().getMarketPrice()%></td>

				<td><%=o.getOrderStatus()%></td>
				<td><%=o.getTradingType()%></td>
				<td><%=o.getOrderType()%></td>
				<td><%=o.getOrderConditions()%></td>

				<td><%=o.getOrderDate()%></td>
				<td><%=o.getOrderAmount()%></td>
				<td><%=o.getOrderUnitPrice()%></td>
				<td><%=o.getOrderAmount() * o.getOrderUnitPrice()%></td>

				<td><%=o.getClosingDate()%></td>
				<td><%=o.getClosingAmount()%></td>
				<td><%=o.getClosingUnitPrice()%></td>
				<td><%=o.getClosingAmount() * o.getClosingUnitPrice()%></td>
				<td align="center">
				<!-- <input type="submit" value="銘柄詳細情報を表示する"></td> -->
					<input type="hidden" name="current_page" value="brandlist">
					<br><button type="submit" name="detail"
						value="<%=o.getBrand().getBrandCode()%>" >詳細閲覧</button><br><br>


			</tr>
			<%
				}
			%>
		</table>

	</form>
	<input type="button" onClick="location.href='mypage.jsp'" value="戻る">

</body>
</html>