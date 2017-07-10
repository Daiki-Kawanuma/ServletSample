<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ibm.jp.icw.model.Brand"%>
<%@ page import="com.ibm.jp.icw.constant.SessionConstants"%>
<%@ page import="com.ibm.jp.icw.model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.jp.icw.model.MarketPrice"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	request.setCharacterEncoding("UTF-8");
	User user = (User) session.getAttribute(SessionConstants.PARAM_USER);

	Brand brand = (Brand) session.getAttribute(SessionConstants.PARAM_BRAND);
	String brandStatus = brand.getBrandStatus().equals("正常銘柄") ? "" : "【" + brand.getBrandStatus() + "】";
	String color = brand.getBrandStatus().equals("正常銘柄") ? "black" : "red";

	ArrayList<MarketPrice> priceList = (ArrayList<MarketPrice>) request.getAttribute("priceList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>銘柄詳細｜TS長谷川証券</title>
<link rel="stylesheet" href="Header.css" type="text/css">
<style>
.tablebrandlist {
	border-style: solid;
	border-width: 0px;
	border-color: black;
}

.tablebrandlist th {
	background-color: #999999;
}

.tablebrandlist td {
	width: 700px;
	height: 70px;
}

<!--
d3用 -->.axis path, .axis line {
	fill: none;
	stroke: #000;
	shape-rendering: crispEdges;
}

.x.axis path {
	display: none;
}

.line {
	fill: none;
	stroke: #1572F9;
	stroke-width: 1.5px;
}
</style>
<body>
	<!-- ヘッダー部分 -->
	<div style="overflow: auto; background-color: #009999;background-clip:border-box;height: 130px;border: solid 0.4em transparent;">
		<div style="float: left;">
			<h1>
				長谷川証券<br>トレーディングシステム
			</h1>
		</div>
		<div style="float: right;">
			<p style="color: white; font-size: 120%; margin: 0px 10px 0px 0px"><%=user.getName()%>さん
			</p>
			<input class="square_btn"
				style="width: 125px; margin: 8px 10px 0px 0px; font-size: 100%"
				type="button" onClick="location.href='mypage.jsp'" value="マイページ">
			<br> <input class="square_btn"
				style="width: 125px; margin: 8px 10px 10px 0px; font-size: 100%;"
				type="button" onClick="location.href='logout'" value="ログアウト">
		</div>
	</div>
	<!-- ヘッダー部分 -->
	<h2 style="color: <%=color%>;"><%=brandStatus + brand.getBrandName()%>
		詳細情報
	</h2>

	<br>
	<br>
	<table class="tablebrandlist" border=1>
		<tr style="color: #FFFFFF">
			<th>銘柄コード</th>
			<th>銘柄名</th>
			<th>市場</th>
			<th>業種</th>
			<th>売買単位</th>
			<th>買い気配値</th>
			<th>売り気配値</th>
		</tr>
		<tr>
			<td><%=brand.getBrandCode()%></td>
			<td><%=brand.getBrandName()%></td>
			<td><%=brand.getMarket()%></td>
			<td><%=brand.getIndustry()%></td>
			<td><%=brand.getTradingUnit()%></td>
			<td><%=brand.getBidPrice()%></td>
			<td><%=brand.getOfferPrice()%></td>


		</tr>
		<tr style="color: #FFFFFF">
			<th>株価</th>
			<th>始値</th>
			<th>終値</th>
			<th>高値</th>
			<th>安値</th>
			<th>年初来高値</th>
			<th>年初来安値</th>

		</tr>
		<tr>
			<td><%=brand.getMarketPrice()%></td>
			<td><%=brand.getOpeningPrice()%></td>
			<td><%=brand.getClosePrice()%></td>
			<td><%=brand.getHighPrice()%></td>
			<td><%=brand.getLowPrice()%></td>
			<td><%=brand.getYearToDateHighs()%></td>
			<td><%=brand.getYearToDateLows()%></td>
		</tr>
	</table>
	<br>
	<br>
	<svg id="chart" style="margin: 0px 0px 0px 50px"></svg>

	<script src="http://d3js.org/d3.v3.min.js"></script>
	<script type="text/javascript">
		// 表示サイズを設定
		var margin = {
			top : 40,
			right : 40,
			bottom : 40,
			left : 100
		};

		var size = {
			width : 1000,
			height : 600
		};

		// 表示するデータ
		var data = [
		<%
			for (MarketPrice price : priceList) {
		%>
		{
			date : "<%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(price.getDate()) %>",
			value : <%= price.getPrice() %> },
		<%
			}
		%>
		];

		// 時間のフォーマット
		var parseDate = d3.time.format("%Y-%m-%d %H:%M:%S").parse;

		// SVG、縦横軸などの設定
		var svg = d3.select("#chart").attr("width", size.width).attr("height",
				size.height).append("g").attr("transform",
				"translate(" + margin.left + "," + margin.top + ")");

		var x = d3.time.scale().range(
				[ 0, size.width - margin.left - margin.right ]);

		var y = d3.scale.linear().range(
				[ size.height - margin.top - margin.bottom, 0 ]);

		var xAxis = d3.svg.axis().scale(x).orient("bottom").tickFormat(
				d3.time.format("%H:%M"));

		var yAxis = d3.svg.axis().scale(y).orient("left");

		var line = d3.svg.line().x(function(d) {
			return x(d.date);
		}).y(function(d) {
			return y(d.value);
		});

		// 描画
		data.forEach(function(d) {
			d.date = parseDate(d.date);
			d.value = +d.value;
		});

		x.domain(d3.extent(data, function(d) {
			return d.date;
		}));
		y.domain(d3.extent(data, function(d) {
			return d.value;
		}));

		svg.append("g").attr("class", "x axis").attr(
				"transform",
				"translate(0, " + (size.height - margin.top - margin.bottom)
						+ ")").call(xAxis);

		svg.append("g").attr("class", "y axis").call(yAxis).append("text")
				.attr("transform", "rotate(-90)").attr("y", 6).attr("dy",
						".7em").style("text-anchor", "end").text("円");

		svg.append("path").datum(data).attr("class", "line").attr("d", line);
	</script>

	<br>
	<br>
	<form action="order" method="POST">
		<input type="hidden" name="current_page" value="branddetail">
		<input class="square_btn" type="submit" value="注文へ進む"
			style="font-size: 20pt" />
	</form>
</body>
</html>