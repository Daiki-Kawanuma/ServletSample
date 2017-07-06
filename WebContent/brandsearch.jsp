
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
<form action="search" method="POST">
	<input type="hidden" name="current_page" value="brandsearch">
	<input type="radio" name="searchtype" value="brandcode">銘柄コード(４桁)から検索<br>
	<input type="radio" name="searchtype" value="brandname">銘柄名から検索<br><br>
	<input type="text" name="searchcondition">
	<input type="submit" value="検索"style="font-size:20pt"/>
	</form>
</body>
</html>