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
<title>Login</title>
<link href="../CSS/stylesheet.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../CSS/signin.css" rel="stylesheet">
</head>
<body>

	<%
		long id = (long) request.getAttribute("matchId");
		int seat = (int) request.getAttribute("seat");
		out.print("您将购买" + id + "场次" + seat + "座");
		session.setAttribute("matchId", id);
		session.setAttribute("seat", seat);
	%>
	<%=request.getAttribute("mess")%>
	<P>
	<div class="container">
		<s:form class="form-signin" action="/attendant/pay" methood="post">
			<div>
				<h2 class="form-signin-heading">确定信息以完成购买</h2>
				<label for="inputName" class="sr-only">Name</label> <input
					type="name" id="name" name="name" class="form-control"
					placeholder="Name" required> <label for="inputName"
					class="sr-only">BankAccount</label> <input type="account"
					id="account" name="account" class="form-control"
					placeholder="BankAccount" required> <label
					for="inputPassword" class="sr-only">Password</label> <input
					type="password" id="password" name="password" class="form-control"
					placeholder="Password" required>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">确定</button>


		</s:form>

	</div>
	<!-- /container -->
</body>
</html>