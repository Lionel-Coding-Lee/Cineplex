<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="Model.Film"%>
<%@ page import="Model.Member"%>
<%@ page import="Model.Match"%>

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


<title>Attendant Film</title>

<!-- Bootstrap core CSS -->
<link href="../CSS/stylesheet.css" rel="stylesheet">

<link href="../CSS/attendant.css" rel="stylesheet">
<script src="../JS/jquery.js"></script>
<script src="../JS/bootstrap.min.js"></script>

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
				<li><a href="/Cineplex/attendant/index">首页</a></li>
				<li class="active"><a href="/Cineplex/attendant/film">电影</a></li>
				<li><a href="/Cineplex/attendant/activity">活动</a></li>
				<li><a href="/Cineplex/attendant/match">放映计划</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div class="container-fluid">
		<div class="container">
			<div class="col-md-6 sidebar">
				<h2 class="sub-header">电影列表</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Name</th>
								<th>Offline</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Film> films = (List<Film>) request.getAttribute("films");
								for (Film film : films) {
									out.print("<tr>" + "<td>" + film.getFilmName() + "</td>"
											+ "<td>" + film.getOffline() + "</td>" + "<td>"
											+ film.getPrice() + "</td>" + "</tr>");
								}
							%>
						</tbody>

					</table>
				</div>
			</div>

			<div class="col-sm-5 col-md-6 sidebar">
				<h2 class="sub-header">发布电影</h2>
				<s:form class="form-signin" action="/attendant/addFilm"
					methood="post">

					<h4 class="form-heading">电影名称</h4>
					<label for="inputName" class="sr-only">Name</label>
					<input type="name" id="name" name="name" class="form-control"
						placeholder="Name" required>
					<h4 class="form-heading">票价</h4>
					<label for="inputprice" class="sr-only">Price</label>
					<input type="price" id="price" name="price" class="form-control"
						placeholder="Price" required>
					<h4 class="form-heading">电影类型</h4>
					<input type="type" list="type_list" name="type" class="form-control"/>
					<datalist id="type_list">
					<option value="鬼畜" />
					<option value="小清新" />
					<option value="喜剧" />
					</datalist>
					<h4 class="form-heading">下线时间</h4>
					<input type="date" name="offline" class="form-control"/>
					<div>
						<h4 class="form-heading"></h4>
						<button class="btn btn-md btn-primary" type="submit">提交</button>
					</div>

				</s:form>

			</div>
		</div>
</body>
</html>