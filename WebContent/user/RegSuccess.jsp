<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register user</title>
</head>
<body>

<H1>Cineplex</H1>
<H2><BR>

<jsp:useBean id="Member"
	type="Model.Member"
	scope="session"></jsp:useBean> 

<H1>Member with id 
<jsp:getProperty name="Member" property="id" />
 was added.</H1>


</body>
</html>