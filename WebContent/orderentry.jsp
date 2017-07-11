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
	int tradingUnit = brand.getTradingUnit();
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
			document.myForm.order_unit_price.value = "";
			document.myForm.order_unit_price.placeholder = "成行の場合、単価は入力できません"
		} else {
			document.myForm.order_unit_price.disabled = false;
			document.myForm.order_unit_price.placeholder = "";
		}
	}

	function checkOrderCondition() {

		if(document.myForm.order_condition[3].checked){
			document.myForm.order_type[1].checked = true;
			checkOrderType();
		} else {
			// document.myForm.order_type[0].disabled = true;
			// document.myForm.order_type[1].disabled = true;
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

	function checkAmount() {

		document.myForm.order_amount.value =
			parseInt(document.myForm.order_amount.value / document.myForm.trading_unit.value) * parseInt(document.myForm.trading_unit.value);
		checkInputText();
	}
</script>

<body>
	<!-- ヘッダー部分 -->
	<div style="overflow: auto; background-color: #009999;background-clip:border-box;height: 135px;border: solid 0.4em transparent;">
		<div style="float: left;">
			<h1>
				長谷川証券<br>トレーディングシステム
			</h1>
		</div>
		<div style="float: right; font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">
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
	<div style="float: left;margin: 8px 50px 50px 0px">
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
	<h3>単元株：<%= brand.getTradingUnit() %></h3>
	</div>
	<form name="myForm" action="order" method="POST">
		<input type="hidden" name="trading_unit" value="<%= tradingUnit %>" >
		<input type="hidden" name="current_page" value="orderentry">

		<div style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;float: left;margin: 8px 50px 50px 0px">
			<h3>1.注文の種類</h3>
			<input type="radio" class="disabled_radio" name="order_type" value="成行" onClick="checkOrderType();" >成行<br>
			<input type="radio" class="disabled_radio" name="order_type" value="指値" onClick="checkOrderType();" >指値<br> <br>
		</div>

		<div style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;float: left;margin: 8px 50px 50px 0px">
			<h3>2.執行条件</h3>
			<input type="radio" name=order_condition value="無条件" onClick="checkOrderCondition();" style="width:50px;height:50px;vertical-align:middle;">無条件<br>
			<input type="radio" name=order_condition value="寄付" onClick="checkOrderCondition();" style="width:50px;height:50px;vertical-align:middle;">寄付<br>
			<input type="radio" name=order_condition value="引け" onClick="checkOrderCondition();" style="width:50px;height:50px;vertical-align:middle;">引け<br>
			<input type="radio" name=order_condition value="指成" onClick="checkOrderCondition();" style="width:50px;height:50px;vertical-align:middle;">指成<br>
		</div>

		<div style="float: left; margin: 8px 50px 0px 0px">
			<h3>3.注文数</h3>
			<input type="text" name="order_amount" placeholder="単元株単位の注文数を入力してください" onkeyup="checkInputText();" onchange="checkAmount();"><br>
		</div>

		<div style="float: left;margin: 8px 50px 0px 0px">
			<h3>4.注文単価</h3>
			<input type="text" name="order_unit_price" onkeyup="checkInputText();"><br>
		</div>

		<div style="float: left;margin: 8px 50px 0px 0px">
			<h3>5.注文合計</h3>
			<input type="text" name="order_sum" readonly="readonly"><br><br>
		</div>

		<div style="float: right;margin: 0px 50px 50px 0px">
			<input class="square_btn" type="submit" value="注文確認へ進む" style="font-size: 20pt" />
		</div>

	</form>
</body>
</html>