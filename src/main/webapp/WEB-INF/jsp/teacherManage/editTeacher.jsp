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
<title>教师管理</title>
</head>
<body>
	<h3 align="center">编辑教师信息</h3>
	<br>
	<form action="<%=basePath %>/teacher/editTeacher.do" method="post">
		<input type="hidden" id="id" name="id" value="${SimTeacher.id}">
		<table width="50%" align="center">
			<tr>
				<td>教师姓名</td>
				<td><input type="text" id="username" name="username" value="${SimTeacher.username}"></td>
			</tr>
			<tr>
				<td>教师编号</td>
				<td><input type="text" id="tCode" name="tCode" value="${SimTeacher.tCode}"></td>
			</tr>
			<tr>
				<td>教师密码</td>
				<td><input type="text" id="password" name="password" value="${SimTeacher.password}"></td>
			</tr>
			<tr>
				<td>教师QQ号</td>
				<td><input type="text" id="qq" name="qq" value="${SimTeacher.qq}"></td>
			</tr>
			<tr>
				<td>教师QQUrl</td>
				<td><input type="text" id="qqUrl" name="qqUrl" value="${SimTeacher.qqUrl}"></td>
			</tr>
			<tr>
				<td>教师QQSrc</td>
				<td><input type="text" id="qqSrc" name="qqSrc" value="${SimTeacher.qqSrc}"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="确定修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>