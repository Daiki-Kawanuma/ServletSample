<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.ibm.jp.icw.model.User"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page import="java.text.NumberFormat"%>
<%
	request.setCharacterEncoding("UTF-8");
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
	String tradingMargin = NumberFormat.getNumberInstance().format(user.getAccountBalance());
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マイページ｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
</head>
<body>
	<!-- ヘッダー部分 -->
	<div style="overflow:auto; background-color: #009999;background-clip:border-box;height: 130px;border: solid 0.4em transparent;">
		<div style="float: left;">
			<h1>
				長谷川証券<br>トレーディングシステム
			</h1>
		</div>
		<div style="float: right;">
			<p style="color: white; font-size: 120%; margin: 20px 10px 0px 0px"><%=user.getName()%>さん
			</p>
			<input class="square_btn"
				style="width: 125px; margin:8px 10px 10px 0px; font-size: 100%;"
				type="button" onClick="location.href='logout'" value="ログアウト">
		</div>
	</div>
	<!-- ヘッダー部分 -->
	<h2>マイページ</h2>
	<br>
	<div style="font-family: 'Hiragino Kaku Gothic Pro', 'ヒラギノ角ゴ Pro W3', Meiryo, メイリオ,Osaka, 'MS PGothic', arial, helvetica, sans-serif;">
	<p style="font-size: 150%">
		ようこそ
		<%=user.getName()%>
		さん
	</p>
	</div>
	<h3>
		お客様の取引余力：<%=tradingMargin%>
		円
	</h3>
	<br>
	<br>
	<input class="square_btn" type="button"
		style="width: 300px; font-size: 120%;"
		onClick="location.href='search'" value="銘柄を検索/買い注文する">
	<br>
	<br>
	<input class="square_btn" type="button"
		style="width: 300px; font-size: 120%;"
		onClick="location.href='orderedinfo'" value="注文状況を確認する">
</body>
</html>