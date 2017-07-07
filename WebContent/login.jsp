<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="Header.css" type="text/css">
</head>
<body>
<header id="hasegawa"> <nav>
	<ul>
	<h1>長谷川証券トレーディングシステム</h1>
</nav> </header>
			<form method="POST" action="login">
				<h2>ログイン画面</h2>
				<hr>
<div align="center">
		<table border="0">
				<p>
					<font color="red"><%=message%>
				</p>
				</font>
				<tr>
					<th><input type="text" name="account_number" placeholder=口座番号を入力してください。
						size="24"></th>
				</tr>
				<tr>
					<th><input type="password" name="login_pass" placeholder=パスワードを入力してください。
						size="24"></th>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="ログイン"></td>
				</tr>
			</form>
		</table>

	</div>
</body>
</html>