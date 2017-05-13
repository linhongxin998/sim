<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理</title>
</head>
<body>
	<h3 align="center">编辑学生信息</h3>
	<br>
	<form action="<%=basePath %>/student/editStudent.do" method="post">
		<input type="hidden" id="id" name="id" value="${SimStudent.id}">
		<table width="50%" align="center">
			<tr>
				<td>学生姓名</td>
				<td><input type="text" id="username" name="username" value="${SimStudent.username}"></td>
			</tr>
			<tr>
				<td>学生学号</td>
				<td><input type="text" id="sCode" name="sCode" value="${SimStudent.sCode}"></td>
			</tr>
			<tr>
				<td>学生密码</td>
				<td><input type="text" id="password" name="password" value="${SimStudent.password}"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="确定修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>