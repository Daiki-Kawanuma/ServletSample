<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
.table4 {
  border-collapse: collapse;

}
.table4 th {
  background-color: #999999;
  width: 700px;
　height: 200px;
}
</style>
<table class="table4" border=1>
 <tr style="color:#FFFFFF">
			<th>銘柄コード</th>
			<th>銘柄名</th>
			<th>市場</th>
			<th>業種</th>
			<th>売買単位</th>
			<th>株価</th>
			<th>始値</th>
			<th>高値</th>
			<th>安値</th>
			<th>アクション</th>
		</tr>

		<tr>
			<td>7150</td>
			<td>MS&ADインシュアランスグループホールディングス</td>
			<td>東証一部</td>
			<td>保険業</td>
			<td>100</td>
			<td>3896</td>
			<td>3877</td>
			<td>3899</td>
			<td>3781</td>
			<td><form action="search" method="POST">
					<input type="hidden" name="current_page" value="brandlist">
					<button type="submit" name="detail"
						value="branddetail">詳細閲覧</button>
					<button type="submit" name="order"
						value="purchase">買い注文</button>
				</form></td>

</table>
</body>
</html>