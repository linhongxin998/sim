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
<title>学生管理</title>
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript">

	/* 删除学生 */
	var deleteStudent=function(id){
		$.ajax({
			url : "<%=basePath %>/student/deleteStudent.do",
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
	
	/* 显示学生列表 */ 
	var showList= function(){
		$.ajax({
			url : "<%=basePath %>/student/showList.do",
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
	
	/* 显示学生列表 */
	var addHtml=function(data){
		var htmlStr="";
		var myobj=eval(data); 
		if(myobj.length>0){
			for(var i=0;i<myobj.length;i++){
				htmlStr +="<tr>"+
				"<td width='10%' align='center'>"+myobj[i].username+"</td>"+
				"<td width='10%' align='center'>"+myobj[i].sCode+"</td>"+
				"<td width='5%' align='right'><a href='<%=basePath %>/student/goToeditStudent.do?id="+myobj[i].id+"'>编辑</a></td>"+
				"<td width='5%' align='left'><input type='button' value='删除' onclick='javascript:deleteStudent("+myobj[i].id+")'></td>"+
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
	<h3 align="center">学生管理</h3>
	<div style="width: 60%;" >
	<h5 align="right"><a href="<%=basePath %>/BackManage/goTobackManage.do">返回后台管理</a></h5>
	</div>
	<form id="fShowList">
		<table width="50%" align="center">
			<tr>
				<td>学生姓名</td>
				<td><input type="text" id="username" name="username"></td>
				<td>学生学号</td>
				<td><input type="text" id="sCode" name="sCode"></td>
				<td><input type="button" onclick="javascript:showList()" value="搜索"></td>
			</tr>
			<tr><td><a href="<%=basePath %>/student/goToAddStudent.do">添加学生</a></td></tr>
		</table>
	</form>
	<br><br><br>
	<table width="60%" align="center">
		<tr>
			<td width="10%" align="center">姓名</td>
			<td width="10%" align="center">学号</td>
			<td width="10%" align="center">操作</td>
		</tr>
	</table>
	<table width="60%" align="center" id="all">
	</table>
</body>
</html>