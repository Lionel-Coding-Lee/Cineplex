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

<title>member Film</title>

<!-- Bootstrap core CSS -->
<link href="../CSS/stylesheet.css" rel="stylesheet">

<link href="../CSS/member.css" rel="stylesheet">
<script type="text/javascript">
	var seat;
	function chooseSeat(num) {
		seat = num;
		//alert("您选择了" + num + "座");
	}
	function buyTicket(id) {
		window.location.href = "/Cineplex/member/prePay?id=" + id + "&seat="
				+ seat;
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
				<li class="active"><a href="/Cineplex/member/index">首页</a></li>
				<li><a href="/Cineplex/member/ticket">我的电影票</a></li>
				<li><a href="/Cineplex/member/activity">活动</a></li>
				<li><a href="/Cineplex/member/person">个人中心</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div class="container-fluid">



		<div class="container-fluid">



			<%
			System.out.println("again");
			List<Film> films = (List<Film>) request.getAttribute("films");
			for (Film f : films) {
				List<Match> match = (List<Match>) request.getAttribute(f
						.getFilmName());
				//out.print("<s:form class='form' action='/attendant/buyTicket' methood='post'>");
				out.print("<div class='col-md-10 col-md-offset-1'>");
				out.print("<h3 class='sub-header'>");
				out.print(f.getFilmName() + "     ￥" + f.getPrice());
				out.print("</h3><div class='table-responsive'><table class='table table-striped'>");
				out.print("<thead><tr><th>Hall</th><th>Time</th><th>Seat</th><th> </th></tr></thead><tbody>");

				for (Match m : match) {
					out.print("<tr>" + "<td>" + m.getHallNum() + "</td>"
							+ "<td>" + m.getTime() + "</td><td>");

					out.print("<div class='btn-group' role='group' aria-label='...'>");
					Boolean seats[] = m.getSeats();
					for (int i = 0; i < 10; i++) {
						int j = i + 1;
						if (seats[i])
							out.print("<button type='button' name='seat' class='btn btn-default' ");
						else
							out.print("<button type='button' class='btn btn-warning disabled' ");
						out.print(" value='" + j + "' onclick='chooseSeat(" + j
								+ ")''>");
						out.print(j);
						out.print("</button>");

					}
					
					out.print("</div>");
					
					out.print("</td><td> <button class='btn btn-primary btn-block' type='post' name='match' value='"
							+ m.getMatchId()
							+ "' onclick='buyTicket("
							+ m.getMatchId()
							+ ")'>"
							+ "购票"
							+ "</button></td></tr>");
				}

				out.print("</tbody></table></div></div>");
				//out.print("</s:form>");
			}
		%>


		</div>



	</div>

</body>
</html>