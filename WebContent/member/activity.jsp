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

<title>Member Activity</title>

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
				<li><a href="/Cineplex/member/index">首页</a></li>
				<li><a href="/Cineplex/member/ticket">我的电影票</a></li>
				<li class="active"><a href="/Cineplex/member/activity">活动</a></li>
				<li><a href="/Cineplex/member/person">个人中心</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="container-fluid">
		<div class="container">
			<s:form class="form" action="/member/addActivity" methood="post">
				<div class="col-md-6 sidebar">
					<h2 class="sub-header">活动列表</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Activity</th>
									<th>Number</th>
									<th>Content</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
										Member member = (Member)session.getAttribute("member");
										long id = member.getId();
										String operation = "参加";
										List<Activity> list = (List<Activity>)request.getAttribute("activitylist");
										for(Activity a : list) {
											out.print("<tr>" + "<td>" + a.getName() + "</td>" + "<td>"
													+ a.getNum() + "</td>" + "<td>"
													+ a.getContent() + "</td>");
											if(a.hasMember(id)){
												operation = "您已参加";
												out.print("<td> <button class='btn btn-info btn-block disabled' name='activity' value='"
														+ a.getActivityId()
														+ "'>"
														+ operation
														+ "</button></td></tr>");
											}else{
												operation  = "参加";
												out.print("<td> <button class='btn btn-primary btn-block' type='submit' name='activity' value='"
														+ a.getActivityId()
														+ "'>"
														+ operation
														+ "</button></td></tr>");
											}
							
												
		
										}
								%>
							</tbody>

						</table>
					</div>

				</div>
			</s:form>
		</div>
	</div>
</body>
</html>