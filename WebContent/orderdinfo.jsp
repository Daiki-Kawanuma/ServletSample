<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    request.setCharacterEncoding("UTF-8");
    String errorMessage = (String) request.getAttribute("message");
    if (message == null) {
        errorMessage = "";
    }
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文状況一覧</title>
</head>
<body>
	<h1>注文状況一覧</h1>
	<p><font color=“red”><%=message%></p></font>
	<table border=1>

		<tr><th>受付番号</th><th>銘柄名</th><th>銘柄コード</th><th>現在値</th></tr>
		<tr><td>00000000</td><td>日本IBM</td><td>0000</td><td>100,000</td></tr>
		<tr><th>注文状況</th><th>売買区分</th><th>注文の種類</th><th>執行条件</th></tr>
		<tr><td>成約済み</td><td>買い</td><td>成行</td><td>無条件</td></tr>
		<tr><th>注文日時</th><th>注文数</th><th>注文単価</th><th>注文合計金額</th></tr>
		<tr><td>20170705</td><td>100</td><td>100,000</td><td>10,000,000</td></tr>
		<tr><th>成約日時</th><th>成約数</th><th>成約単価</th><th>成約合計金額</th></tr>
		<tr><td>20170706</td><td>100</td><td>100,000</td><td>10,000,000</td></tr>
	</table>

</body>
</html>