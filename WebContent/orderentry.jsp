<%@page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ibm.jp.icw.model.Brand"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page import="com.ibm.jp.icw.model.User"%>
<%@ page import="java.text.NumberFormat"%>
<%
	request.setCharacterEncoding("UTF-8");
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
	String tradingMargin = NumberFormat.getNumberInstance().format(user.getAccountBalance());

	Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);
	String brandStatus = brand.getBrandStatus().equals("正常銘柄") ? "" : "【" + brand.getBrandStatus() + "】";
	String color = brand.getBrandStatus().equals("正常銘柄") ? "black" : "red";
	String nowPrice = NumberFormat.getNumberInstance().format(brand.getMarketPrice());

	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>買い注文｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
<style type="text/css">
table, td {
	border-style: solid;
	border-width: 1px;
	border-color: black;
}
</style>
</head>

<script type="text/javascript">
	function checkOrderType() {

		if(document.myForm.order_type[0].checked){
			document.myForm.order_unit_price.disabled = true;
			document.myForm.order_unit_price.value = ""
		} else {
			document.myForm.order_unit_price.disabled = false;
		}
	}

	function checkOrderCondition() {

		if(!document.myForm.order_condition[3].checked){
			document.myForm.order_type[0].disabled = false;
			document.myForm.order_type[1].disabled = false;
		} else {
			document.myForm.order_unit_price.disabled = false;
			document.myForm.order_type[0].checked = false;
			document.myForm.order_type[1].checked = false;
			document.myForm.order_type[0].disabled = true;
			document.myForm.order_type[1].disabled = true;
		}
	}

	function checkInputText() {

		/*document.myForm.order_amount = document.myForm.order_amount.value.replace(/,/g, "");
		document.myForm.order_unit_price = document.myForm.order_unit_price.value.replace(/,/g, "");*/

		var value = document.myForm.order_amount.value * document.myForm.order_unit_price.value;

		if(value > 0){
			document.myForm.order_sum.value = document.myForm.order_amount.value
			* document.myForm.order_unit_price.value;
		} else {
			document.myForm.order_sum.value = "";
		}

		/*document.myForm.order_sum.value = document.myForm.order_sum.value.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		document.myForm.order_amount.value = document.myForm.order_amount.value.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		document.myForm.order_unit_price.value = document.myForm.order_unit_price.value.replace(/\B(?=(\d{3})+(?!\d))/g, ',');*/
	}
</script>

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
	<h2>買い注文</h2>
	<h3>
		お客様の取引余力：<%=tradingMargin%>
		円
	</h3>
	<p>
		<font color="red"><%=message%></font>
	</p>
	<h2 style="color: <%=color%>;"><%=brandStatus + brand.getBrandName()%></h2>
	<h3>
		銘柄コード：<%=brand.getBrandCode()%></h3>
	<h3>
		現在価格：<%=nowPrice%>
		円
	</h3>
	<h3>単元株：<%= brand.getTradingUnit() %>></h3>
	<form name="myForm" action="order" method="POST">
		<input type="hidden" name="current_page" value="orderentry">
		<h3>注文の種類</h3>
		<input type="radio" name="order_type" value="成行" onClick="checkOrderType();">成行<br> <input
			type="radio" name="order_type" value="指値" onClick="checkOrderType();">指値<br> <br>
		<h3>執行条件</h3>
		<input type="radio" name=order_condition value="無条件" onClick="checkOrderCondition();">無条件<br>
		<input type="radio" name=order_condition value="寄付" onClick="checkOrderCondition();">寄付<br>
		<input type="radio" name=order_condition value="引け" onClick="checkOrderCondition();">引け<br>
		<input type="radio" name=order_condition value="指成" onClick="checkOrderCondition();">指成<br>
		<h3>注文数</h3>
		<input type="text" name="order_amount" onkeyup="checkInputText();"><br>
		<h3>注文単価</h3>
		<input type="text" name="order_unit_price" onkeyup="checkInputText();"><br>
		<h3>注文合計</h3>
		<input type="text" name="order_sum" readonly="readonly"><br><br>
		<input class="square_btn" type="submit" value="注文確認へ進む"
			style="font-size: 20pt" />
	</form>
</body>
</html>