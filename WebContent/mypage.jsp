<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マイページ｜TS長谷川証券</title>
</head>
<body>
<h1>マイページ</h1>
<br>
<p>ようこそ、<%= person.getName() %>さん</p><br>

<input type="button" onClick="location.href=brandsearch.jsp" value="銘柄を検索/買い注文する"><br><br>
<input type="button" onClick="location.href=orderedinfo.jsp" value="注文状況を確認する">


</body>
</html>