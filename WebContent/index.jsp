<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errormessage = (String) request.getAttribute("errormessage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ICW動作確認サンプル</title>
	</head>
	<body>
		<h1>検索ページ</h1>
		<form method="post">
			ユーザーIDを入力してください:<input type="text" name="userid">
			<input type="submit">
		</form>
		<% if (errormessage != null) { %>
		<p style="color: red"><%= errormessage %></p>
		<% } %>
	</body>
</html>