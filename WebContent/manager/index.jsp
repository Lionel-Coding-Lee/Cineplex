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
<script type="text/javascript">
function buyTicket(id) {
	window.location.href="/Cineplex/attendant/prePay?id="+id;
}
</script>

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
				<li class="active"><a href="/Cineplex/manager/index">首页</a></li>
				<li><a href="/Cineplex/manager/match">放映计划</a></li>
				<li><a href="/Cineplex/manager/statistic">统计</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div class="container-fluid">
	
		

			<%
					System.out.println("index");
					List<Film> films = (List<Film>) request.getAttribute("manafilms");
					for (Film f : films) {
						List<Match> match = (List<Match>) request.getAttribute(f
								.getFilmName());
						//out.print("<s:form class='form' action='/attendant/buyTicket' methood='post'>");
						out.print("<div class='col-md-8 col-md-offset-1'>");
						out.print("<h3 class='sub-header'>");
						out.print(f.getFilmName() + "     ￥" + f.getPrice());
						out.print("</h3><div class='table-responsive'><table class='table table-striped'>");
						out.print("<thead><tr><th>Hall</th><th>Time</th><th> </th></tr></thead><tbody>");
						
						for(Match m : match) {
							out.print("<tr>" + "<td>" + m.getHallNum() + "</td>" +  "<td>"
									+ m.getTime() + "</td>");
							out.print("</tr>");
						}
			
						out.print("</tbody></table></div></div>");
						//out.print("</s:form>");
					}
				%>


		

	</div>

</body>
</html>