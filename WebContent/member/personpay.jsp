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

	<h3>您将充值以成为会员或续费</h3>
	<P>
	<div class="container">
		<s:form class="form-signin" action="/member/personpay" methood="post">
			<div>
				<h2 class="form-signin-heading">确定信息</h2>
				<h4>充值金额</h4>
				<input type="name" list="name_list" name="num" class="form-control" required/>
					<datalist id="name_list" class="sr-only" >
					<option value="100" />
					<option value="200" />
					<option value="300" />
					<option value="400" />
					<option value="500" />
					<option value="600" />
					<option value="700" />
					<option value="800" />
					<option value="900" />
					</datalist>
				
				<h4>银行账户</h4>
				<label for="inputName" class="sr-only">BankAccount</label> <input
					type="account" id="account" name="account" class="form-control"
					placeholder="BankAccount" required> 
					<h4>银行密码</h4>
					<label for="inputPassword" class="sr-only">Password</label> <input
					type="password" id="password" name="password" class="form-control"
					placeholder="Password" required>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">确定</button>


		</s:form>

	</div>
	<!-- /container -->
</body>
</html>