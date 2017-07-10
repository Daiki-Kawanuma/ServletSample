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
<title>ログイン｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
</head>
<body>
	<header id="hasegawa"> <nav>
	<ul>
		<h1 class="font1">
			長谷川証券<br>トレーディングシステム
		</h1>
	</nav> </header>
	<div align="center">
		<table border="0">
			<form-wrapper>
			<form method="POST" action="login">
				<div class=hako>
					<div class=logmessage>
						<h2><font color="#777">ログイン</font></h2>
						<font color="red"><%=message%>
					</div>
					</font>
					<div class="form-item">
						<label for="account_number"></label> <input type="text"
							name="account_number" required="required "
							placeholder=口座番号を入力してください。 style="ime-mode:disabled"> </input>
					</div>
					<div class="form-item">
						<input type="password" name="login_pass" required="required"
							placeholder=パスワードを入力してください。> </input>
					</div>
					<br>
					<div class="button-panel">
						<input type="submit" class="button title=" ログイン" value=ログインする></input>
					</div>
					<br>
				</div>
			</form-wrapper>

			</form>

		</table>

	</div>

</body>
</html>