<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="Model.Film"%>
<%@ page import="Model.Member"%>
<%@ page import="Model.Match"%>
<%@ page import="Model.Age"%>
<%@ page import="Model.Booking"%>

<%@ page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page import="java.util.*"%>
<%
	String path = request.getServletPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=utf-8" -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Manager Match</title>

<!-- Bootstrap core CSS -->
<link href="../CSS/stylesheet.css" rel="stylesheet">

<link href="../CSS/attendant.css" rel="stylesheet">

<!-- script type="text/javascript">
	function pass() {
		 document.getElementById("passList").style.visibility = "visible";
		 document.getElementById("waitList").style.visibility = "hidden";
	}
	function wait() {
		 document.getElementById("passList").style.visibility = "hidden";
		 document.getElementById("waitList").style.visibility = "visible";
	}
</script -->
</head>
<body>
	<nav class="navbar navbar-default purplecolor">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Cineplex</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/Cineplex/manager/index">首页</a></li>
				<li><a href="/Cineplex/manager/match">放映计划</a></li>
				<li class="active"><a href="/Cineplex/manager/statistic">统计</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div>
		<div class="container-fliud">
			<div class='col-md-5 col-md-offset-1'>
				<h3>会员统计</h3>
				<div class='table-responsive'>
					<table class='table table-striped'>
						<thead>
							<tr>
								<th>年龄统计</th>
								<th>人数</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Age> ageList = (List<Age>) request.getAttribute("ageList");
								for (Age a : ageList) {
									out.print("<tr><td>");
									out.print(a.getAge());
									out.print("</td><td>");
									out.print(a.getNum());
									out.print("</td></tr>");
								}
							%>
						</tbody>
					</table>
				</div>
				<h3>票房统计</h3>
				<div class='table-responsive'>
					<table class='table table-striped'>
						<thead>
							<tr>
								<th>电影</th>
								<th>票房</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Booking> bl = (List<Booking>) request.getAttribute("bookingList");
							for (Booking b : bl) {
								out.print("<tr><td>");
								out.print(b.getName());
								out.print("</td><td>");
								out.print(b.getOffice());
								out.print("</td></tr>");
		
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
								
	</div>
</body>
</html>