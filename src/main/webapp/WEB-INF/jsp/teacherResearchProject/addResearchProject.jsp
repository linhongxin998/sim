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
<title>科研项目</title>
</head>
<body>
	<h3 align="center">添加科研信息</h3>
	<div style="width: 60%; overflow: hidden; margin: 0 auto">
		<h5 align="right">
			<a href="<%=basePath%>/login/dropLogin.do">退出登录 </a>
		</h5>
	</div>
	<br>
	<form action="<%=basePath %>/researchproject/addResearchProject.do" method="post"enctype="multipart/form-data">
		<table width="60%" align="center">
			<tr>
				<td>科研项目编号</td>
				<td><input type="text" id="rCode" name="rCode"></td>
			</tr>
			<tr>
				<td>科研项目名称</td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td>科研项目简介</td>
				<td><input type="text" id="intro" name="intro"></td>
			</tr>
			<tr>
				<td>科研项目内容</td>
				<td><input type="text" id="content" name="content"></td>
			</tr>
			<tr>
				<td>请选择要上传的附件</td>
				<td><input type="file" name="file" id="file"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="确定添加"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>