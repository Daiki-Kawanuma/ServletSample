
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>銘柄検索｜TS長谷川証券</title>
<style type="text/css">
	table,td {
		border-style: solid;
		border-width: 1px;
		border-color: black;
	}
</style>
</head>
<body>
<h1>銘柄を検索</h1>
<form action="questionnaire" method="POST">
<!-- 	検索条件を入力してください：<br><br> -->
<!-- 	<select name="searchtype" style="font-size:72pt"> -->
	<input type="radio" name="searchtype" value="brandcode">銘柄コード(４桁)から検索<br>
	<input type="radio" name="searchtype" value="brandname">銘柄名から検索<br><br>

<!-- 検索ボタンを大きくしたい

例えば

.button{
height:30px;
width:100px;
}

とCSSで設定したら

html部分には

<input type="submit" value="検索" class="button">

と書けばよいだけだった。 -->



	<input type="text" name="searchcondition">
	<input type="submit" value="検索"style="font-size:20pt"/>
	</form>
</body>
</html>