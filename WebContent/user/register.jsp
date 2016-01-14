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
<link href="../CSS/stylesheet.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../CSS/signin.css" rel="stylesheet">
</head>
<body>
	<H1><%=request.getAttribute("mess")%></H1>
	<BR>
	<p>
	<div class="container">
		<s:form class="form-signin" action="/user/register" methood="post">

			<h2 class="form-signin-heading">注册</h2>
			<h4>用户名</h4>
			<label for="inputName" class="sr-only">Name</label>
			<input type="name" id="name" name="name" class="form-control"
				placeholder="Name" required>
			<h4>密码</h4>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="password" name="password"
				class="form-control" placeholder="Password" required>
				<h4>确认密码</h4>
			<label for="inputPasswordAgain" class="sr-only">RetypePassword</label>
			<input type="password" id="password2" name="password2"
				class="form-control" placeholder="Password" required>
				<h4>生日</h4>
			<label for="inputName" class="sr-only">Birthday</label>
			<input type="name" id="name" name="year" class="form-control"
				placeholder="年" required>
				<input type="name" id="name" name="month" class="form-control"
				placeholder="月" required>
				<input type="name" id="name" name="day" class="form-control"
				placeholder="日" required>
			<h4>联系电话</h4>
			<label for="inputName" class="sr-only">Phone</label>
			<input type="phone" id="phone" name="phone"
				class="form-control" placeholder="PhoneNumber">
			<div class="checkbox middle">
				<input type="checkbox" value="remember-me" required>

				<!-- Button trigger modal -->
				<label type="button" data-toggle="modal" data-target="#myModal">用户协议</label>

				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body">...</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
				<button class="btn btn-lg btn-primary btn-block" type="reset">重置</button>
			</div>
		</s:form>
		</td>
		</tr>
		</table>
</body>
</html>