<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科研信息管理系统首页</title>
</head>
<body>
	<br><br><br>
	<h3 align="center">欢迎您</h3>
	<br><br><br>
	<div align="center"><a href="<%=basePath %>/login/goToLogin.do" >点击此处登录</a></div>
</body>
</html>