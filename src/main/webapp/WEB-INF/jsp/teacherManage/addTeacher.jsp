<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
</head>
<body>
	<h3 align="center">教师学生</h3>
	<br>
	<form action="<%=basePath %>/teacher/addTeacher.do" method="post">
		<table width="50%" align="center">
			<tr>
				<td>教师姓名</td>
				<td><input type="text" id="username" name="username"></td>
			</tr>
			<tr>
				<td>教师编号</td>
				<td><input type="text" id="tCode" name="tCode"></td>
			</tr>
			<tr>
				<td>教师密码</td>
				<td><input type="text" id="password" name="password"></td>
			</tr>
			<tr>
				<td>教师QQ号</td>
				<td><input type="text" id="qq" name="qq"></td>
			</tr>
			<tr>
				<td>教师QQUrl</td>
				<td><input type="text" id="qqUrl" name="qqUrl"></td>
			</tr>
			<tr>
				<td>教师QQSrc</td>
				<td><input type="text" id="qqSrc" name="qqSrc"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="确定添加"></td>
			</tr>
		</table>
	</form>
</body>
</html>