<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Login</title>
<link
	href="../CSS/stylesheet.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../CSS/signin.css" rel="stylesheet">

</head>
<body>

	<%
		request.setAttribute("mess", "Welcome to Cineplex");
	%>
	<H1><%=request.getAttribute("mess")%></H1>

	<P>
	<div class="container">
		<s:form class="form-signin" action="/user/login" methood="post">

			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputName" class="sr-only">Name</label>
			<input type="name" id="name" name="name" class="form-control"
				placeholder="Name" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="password" name="password"
				class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</s:form>
		<table align="center" border="0">

			<tr>
				<td colspan="2" align="center"><a
					href="/Cineplex/manager/login.jsp">经理入口</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="/Cineplex/attendant/login.jsp">服务入口</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="/Cineplex/user/register.jsp">注册</a></td>
			</tr>

		</table>
	</div>
	<!-- /container -->

</body>
</html>

