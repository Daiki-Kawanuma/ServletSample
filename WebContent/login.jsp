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
</head>
<body>
	<h1>長谷川証券トレーディングシステム</h1>
	<hr>
	<div align="center">
		<table border="0">
			<form method="POST" action="login">
				<h2>ログイン画面</h2>
				<p>
					<font color="red"><%=message%>
				</p>
				</font>
				<tr>
					<th>口座番号</th>
					<td><input type="text" name="account_number"
						size="24"></td>
				</tr>
				<tr>
					<th>ログインパスワード</th>
					<td><input type="password" name="login_pass"
						size="24"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="ログイン"></td>
				</tr>
			</form>
		</table>

	</div>
</body>
</html>