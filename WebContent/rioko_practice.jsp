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
<link rel="stylesheet" href="rioko_practice.css" type="text/css">
</head>
<!-- 	<h1>長谷川証券<br>トレーディングシステム</h1> -->

<body>
<div id="header-fixed">
                         <div id="header-bk">
                                <div id="header">・・・</div>
                         </div>
                  </div>
                  <div id="body-bk">
                         <div id="body">・・・</div>
                  </div>
                  <div id="footer-fixed">
                         <div id="footer-bk">
                                <div id="footer">・・・</div>
                         </div>
                  </div>
		<table border="0">
		<form-wrapper>
			<form method="POST" action="login">
				<h2>ログイン画面</h2>
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
				</form-wrapper>
			</form>
		</table>
</body>
</html>