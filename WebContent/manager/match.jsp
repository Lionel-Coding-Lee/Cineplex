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
				<li class="active"><a href="/Cineplex/manager/match">放映计划</a></li>
				<li><a href="/Cineplex/manager/statistic">统计</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div class="container-fluid">
		<div class="container">
			<s:form class="form" action="/manager/passMatch"
				methood="post">
				<div class="col-md-6 sidebar">
					<h2 class="sub-header">待审计划</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>FilmName</th>
									<th>Hall</th>
									<th>Pass</th>
									<th>Date</th>
									<th>Check</th>
								</tr>
							</thead>
							<tbody>
								<%
									List<Film> films1 = (List<Film>) request.getAttribute("films1");
										List<Match> waitmatches = (List<Match>) request
												.getAttribute("waitmatches");
										for (Match match : waitmatches) {
											String filmName = "Yeah";
											long id = match.getFilmId();
											for (Film film : films1) {
												if (id == film.getFilmNumber())
													filmName = film.getFilmName();
											}
											out.print("<tr>" + "<td>" + filmName + "</td>" + "<td>"
													+ match.getHallNum() + "</td>" + "<td>"
													+ match.getPass() + "</td>" + "<td>"
													+ match.getTime() + "</td>");
											out.print("<td> <button class='btn btn-primary btn-block' type='submit' name='match' value='"
													+ match.getMatchId()
													+ "'>"
													+ "通过"
													+ "</button></td></tr>");
										}
								%>
							</tbody>

						</table>
					</div>

				</div>
			</s:form>
		</div>

		<div class="container-fluid">
			<div class="container">
				<div class="col-sm-5 col-md-6 sidebar">
					<h2 class="sub-header">通过计划</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>FilmName</th>
									<th>Hall</th>
									<th>Pass</th>
									<th>Date</th>
								</tr>
							</thead>
							<tbody>
								<%
								List<Film> films2 = (List<Film>) request.getAttribute("films2");
									List<Match> passmatches = (List<Match>) request
											.getAttribute("passmatches");
									for (Match match : passmatches) {
										String filmName = "Yeah";
										long id = match.getFilmId();
										for (Film film : films2) {
											if (id == film.getFilmNumber())
												filmName = film.getFilmName();
										}
										out.print("<tr>" + "<td>" + filmName + "</td>" + "<td>"
												+ match.getHallNum() + "</td>" + "<td>"
												+ match.getPass() + "</td>" + "<td>" + match.getTime()
												+ "</td>" + "</tr>");
									}
								%>
							</tbody>

						</table>
					</div>
				</div>

			</div>
</body>
</html>