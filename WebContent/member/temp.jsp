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
				<li><a href="/Cineplex/member/index">首页</a></li>
				<li><a href="/Cineplex/member/ticket">我的电影票</a></li>
				<li><a href="/Cineplex/member/activity">活动</a></li>
				<li class="active"><a href="/Cineplex/member/person">个人中心</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div class="container-fluid">



		<div class="container-fluid">



		<%
			Member member = (Member) request.getAttribute("member");
			//out.print();
		
		out.print("<h4>用户名</h4>");
		out.print("<label>" + member.getName() +"</label>");
		out.print("<h4>会员等级</h4>");
		out.print("<label>" + member.getRank() +"</label>");
		out.print("<h4>出生日期</h4>");
		out.print("<label>" + member.getBirthday() +"</label>");
		out.print("<h4>账户状态</h4>");
		String status = null;
		if(member.getIsFrozen())
			status = "冻结";
		else
			status = "激活";
		out.print("<label>" + status +"</label>");
		out.print("<h4>最近账户活动时间</h4>");
		out.print("<label>" + member.getLastRecord() +"</label>");
		out.print("<h4>联系方式</h4>");
		out.print("<label>" + member.getPhoneNumber() +"</label>");
		//out.print();
		
		%>


		</div>



	</div>

</body>
</html>