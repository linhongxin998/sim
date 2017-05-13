<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setCharacterEncoding("utf-8");
%>
<%!
	public String formatDate(Long date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科研信息</title>
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript">
	var deleteResearchproject=function(id){
		$.ajax({
			url : "<%=basePath %>/researchproject/deleteResearchproject.do",
			data : {
				id : id
			},
			type : "Post",
			dataType : "text",
			success : function (data){
				showList();
			},
			error : function (data){
				alert("删除数据失败");
				showList();
			}
		});
	}
	
	/* 显示科研数据列表 */
	var showList= function(){
		$.ajax({
			url : "<%=basePath %>/researchproject/showList.do",
			data : $('#fShowList').serialize(),
			type : "Post",
			dataType : "json",
			success : function (data){
				addHtml(data);
			},
			error : function (data){
				alert("获取数据失败");
			}
		});
	}
	
	var addHtml=function(data){
		var htmlStr="";
		var myobj=eval(data); 
		if(myobj.length>0){
			for(var i=0;i<myobj.length;i++){
				htmlStr +="<tr>"+
				"<td width='10%'>"+myobj[i].rCode+"</td>"+
				"<td width='10%'><a href='<%=basePath%>researchproject/ResearchprojectDetail.do?id="+myobj[i].id+"'>"+myobj[i].name+"</a></td>"+
				"<td width='10%'>"+myobj[i].createTime+"</td>"+
				"<td width='10%'>"+myobj[i].updateTime+"</td>"+
				"<td width='3%'><a href='<%=basePath%>researchproject/goToResearchproject.do?id="+myobj[i].id+"'>编辑</a></td>"+
				"<td width='3%'><input type='button' value='删除' onclick='javascript:deleteResearchproject("+myobj[i].id+")'></td>"+
				"</tr>";	
			}
		}else{
			htmlStr="<tr><td>暂无相关数据</td></tr>";
		}
		$("#all").html(htmlStr);
	}
	
	$(document).ready(function(){
		showList();
	})
</script>
</head>
<body>
	<h3 align="center">科研信息</h3>
	<div align="center">${loginUser.username}</div>
	<br><br>
	<form id="fShowList">
		<table width="60%" align="center">
			<tr>
				<td>科研项目编号</td>
				<td><input type="text" id="rCode" name="rCode"></td>
				<td>科研项目名称</td>
				<td><input type="text" id="name" name="name"></td>
				<td><input type="button" onclick="javascript:showList()" value="搜索"></td>
			</tr>
			<tr><td><a href="<%=basePath %>/researchproject/goToAddResearchProject.do">添加</a></td></tr>
		</table>
	</form>
	
	<br><br><br>
	<table width="60%" align="center">
		<tr>
			<td width="10%">科研项目编号</td>
			<td width="10%">科研项目名称</td>
			<td width="10%">发布时间</td>
			<td width="10%">更新时间</td>
			<td width="6%" align="center">操作</td>
		</tr>
	</table>
	<table width="60%" align="center" id="all">
	</table>
</body>
</html>