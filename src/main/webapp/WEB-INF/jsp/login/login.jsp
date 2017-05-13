<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科研信息管理系统登录</title>
</head>
<body>
	<h1 width="60%" align="center">请登录</h1>
	${msg}
	<form action="<%=basePath %>/login/doLogin.do" method="post">
	<div width="60%" align="center"><tr>请输入用户名和密码：<br><br></tr></div>
	
		<table width="30%" align="center">
			<tr>
				<td>用户名</td>
				<td><input type="text" id="username" name="username"></td>
			</tr>
			<tr>
			<td>密码</td>
			<td ><input type="text" id="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="radio" name="identity" checked="checked" value="student"></td>
				<td>学生</td>
			</tr>
			<tr>
				<td><input type="radio" name="identity" value="teacher"></td>
				<td>教师</td>
			</tr>
			<tr>
				<td><input type="radio" name="identity" value="admin"></td>
				<td>管理员</td>
			</tr>
			
				
			<tr>
				<td><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form>
	<div align="center"><a href="<%=basePath %>/login/studentAndVisitorLogin.do" >以游客身份进入</a></div>
</body>
</html>