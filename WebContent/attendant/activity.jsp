<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="Model.Film"%>
<%@ page import="Model.Member"%>
<%@ page import="Model.Match"%>
<%@ page import="Model.Activity"%>

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
				<li><a href="/Cineplex/attendant/film">电影</a></li>
				<li class="active"><a href="/Cineplex/attendant/activity">活动</a></li>
				<li><a href="/Cineplex/attendant/match">放映计划</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div class="container-fluid">
		<div class="container">
			<div class="col-md-6 sidebar">
				<h2 class="sub-header">活动列表</h2>
				<div class="bs-example" data-example-id="list-group-custom-content">
					<div class="list-group">
						<div class="list-group-item">
						<%
							List<Activity> list = (List<Activity>)request.getAttribute("activities");
							for(Activity a : list) {
								out.print("<div class='panel panel-info'><div class='panel-body'>");
								//out.print("<a>");
								//out.print("<h4 class='list-group-item-heading'>");
								out.print(a.getName());
								out.print("<span class='badge fixed-right'>");
								out.print(a.getNum());
								out.print("</span>");
								out.print("</div><div class='panel-footer'>");
								//out.print("</h4>");
								//out.print("<p class='list-group-item-text'>");
								out.print(a.getContent());
								out.print("</div></div>");
								//out.print("</p>");
								//out.print("</a>");
							}
						%>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-5 col-md-6 sidebar">
				<h2 class="sub-header">发布活动</h2>
				<s:form class="form-signin" action="/attendant/addActivity"
					methood="post">

					<h4 class="form-heading">活动名称</h4>
					
					<input type="name" id="name" name="name" class="form-control"
						placeholder="Name" required>
					<h4 class="form-heading">活动内容</h4>

					<textarea rows="3" id="content" name="content" class="form-control"
						placeholder="Content" required></textarea>
						
					<div>
						<h4 class="form-heading"></h4>
						<button class="btn btn-md btn-primary" type="submit">提交</button>
					</div>

				</s:form>

			</div>
		</div>
</body>
</html>