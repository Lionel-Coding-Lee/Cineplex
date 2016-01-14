<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.Film"%>
<%@ page import="Model.Member"%>
<%@ page import="Model.Match"%>
<%@ page import="Model.Ticket"%>

<%@ page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page import="java.util.*"%>
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

<title>Member Index</title>

<!-- Bootstrap core CSS -->
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="starter-template.css" rel="stylesheet">

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
				<li><a href="/Cineplex/member/index">首页</a></li>
				<li class="active"><a href="/Cineplex/member/ticket">我的电影票</a></li>
				<li><a href="/Cineplex/member/activity">活动</a></li>
				<li><a href="/Cineplex/member/person">个人中心</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>


		<div class="container-fluid">
		<div class="container">
			<div class="col-md-6 sidebar">
				<h2 class="sub-header">我的电影票</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>FilmName</th>
								<th>Hall</th>
								<th>Seat</th>
								<th>Time</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Ticket> tl = (List<Ticket>)request.getAttribute("tickets");
								List<Match> ml = (List<Match>)request.getAttribute("matches");
								for (Ticket t : tl) {
									Match match = new Match();
									for(Match m : ml) {
										if(m.getMatchId() == t.getMatchId())
											match = m;
									}
									out.print("<tr>" + "<td>" + t.getFilmName() + "</td>"
											+ "<td>" + match.getHallNum() + "</td>" + "<td>"
											+ t.getSeat() + "</td>" + "<td>"
											+ match.getTime() + "</td>" + "</tr>");
								}
							%>
						</tbody>

					</table>
				</div>
			</div>
		</div>
	</div>

	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>