<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理首页</title>
</head>
<body>
	<h3 width="60%" align="center">后台管理首页</h3>
	<div style="width: 60%; overflow: hidden; margin: 0 auto">
		<h5 align="right">
			<a href="<%=basePath%>/login/dropLogin.do">退出登录 </a>
		</h5>
	</div>
	<br>
	<br>
	<table width="60%" align="center">
		<tr>
			<td><a href="<%=basePath%>BackManage/goToStudentManage.do">学生管理</a></td>
			<td><a href="<%=basePath%>BackManage/goToTeacherManage.do">教师管理</a></td>
			<td><a href="<%=basePath%>BackManage/goToLeaveWordManage.do">留言管理</a></td>
		</tr>
	</table>
</body>
</html>