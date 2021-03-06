<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.jp.icw.model.Order"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page import="com.ibm.jp.icw.model.User"%>

<%
	request.setCharacterEncoding("UTF-8");
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);

	ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderlist");

	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type " content="text /html; charset =UTF-8 ">
<title>注文状況一覧｜TS長谷川証券</title>
<link rel="stylesheet " href="Header.css " type="text/css">
<style>
.tablechumonjokyo {
	border-style: solid;
	border-width: 1px;
	border-color: black;
}

.tablechumonjokyo th {
	background-color: #999999;
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
		<div style="float: right; color: white;font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">
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
	<h2>注文状況一覧</h2>
	<p><%=message%></p>
	<form method="POST" action="orderedinfo">
		<p style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">受付番号から注文を検索することができます。</p>
		<br> <br> <input type="text" name="searchreceptno" /> <input
			class="square_btn" type="submit" value="検索" style="font-size: 20pt" />
	</form>
	<form method="POST" action="search">
	<br><br>
	<div style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">
		<table class="tablechumonjokyo" border=1>
			<tr style="color: #FFFFFF">
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
				<th width="110px">銘柄詳細</th>
			</tr>
			<%
				for (Order o : orderList) {
			%>
			<tr align="center">
				<td><%=o.getReceptionNumber()%></td>
				<td
					style="color: <%=o.getBrand().getBrandStatus().equals("正常銘柄") ? "black" : "red"%>;"><%=o.getBrand().getBrandStatus().equals("正常銘柄") ? o.getBrand().getBrandName()
						: "【" + o.getBrand().getBrandStatus() + "】" + o.getBrand().getBrandName()%></td>
				<td><%=o.getBrand().getBrandCode()%></td>
				<td><%=(int) o.getBrand().getMarketPrice()%> 円</td>

				<td><%=o.getOrderStatus()%></td>
				<td><%=o.getTradingType().equals("B") ? "買い注文" : "売り注文"%></td>
				<td><%=o.getOrderType()%></td>
				<td><%=o.getOrderConditions()%></td>

				<td><%=new SimpleDateFormat("yyyy/MM/dd").format(o.getOrderDate())%></td>
				<td><%=NumberFormat.getNumberInstance().format(o.getOrderAmount())%></td>
				<td><%=NumberFormat.getNumberInstance().format(o.getOrderUnitPrice())%>
					円</td>
				<td><%=NumberFormat.getNumberInstance().format(o.getOrderAmount() * o.getOrderUnitPrice())%>
					円</td>

				<td><%=o.getClosingDate() == null ? "-"
						: new SimpleDateFormat("yyyy/MM/dd").format(o.getClosingDate())%></td>
				<td><%=o.getClosingAmount() == 0 ? "-"
						: NumberFormat.getNumberInstance().format(o.getClosingAmount())%></td>
				<td><%=o.getClosingUnitPrice() == 0 ? "-"
						: NumberFormat.getNumberInstance().format(o.getClosingUnitPrice()) + " 円"%></td>
				<td><%=o.getClosingAmount() == 0 ? "-"
						: NumberFormat.getNumberInstance().format(o.getClosingAmount() * o.getClosingUnitPrice())
								+ " 円"%></td>
				<td align="center">
					<!-- <input type="submit" value="銘柄詳細情報を表示する"></td> --> <input
					type="hidden" name="current_page" value="brandlist"> <br>
					<button class="square_btn" type="submit" name="detail" value="<%=o.getBrand().getBrandCode()%>" style="width: 100%; height: 100%; font-size: 100%;">銘柄詳細</button> <br> <br>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	</form>
	<!--  <input class="square_btn" type="button" onClick="location.href='mypage.jsp'" value="戻る" style="float: right; width: 110px; font-size: 100%"> -->

</body>
</html>
