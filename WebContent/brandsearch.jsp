
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page import="com.ibm.jp.icw.model.User"%>
<%
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>銘柄検索｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
<style type="text/css">
table, td {
	border-style: solid;
	border-width: 1px;
	border-color: black;
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
	<h2>銘柄を検索</h2>
	<form action="search" method="POST">
		<input type="hidden" name="current_page" value="brandsearch">
		<p>1. 検索方法を選択してください。</p>
		<br> <input type="radio" name="searchtype" value="brandcode">銘柄コード(４桁)から検索<br>
		<input type="radio" name="searchtype" value="brandname">銘柄名から検索<br>
		<br>
		<p>2. 検索条件を入力してください。</p>
		<br> <input type="text" name="searchcondition" /> <input
			class="square_btn" type="submit" value="検索" style="font-size: 20pt" />
	</form>
	<p>
		<font color="red"><%=message%></font>
	</p>
</body>
</html>