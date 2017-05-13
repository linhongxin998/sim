<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${researchProject.name}</title>
<style>
/*css注释：为了方便截图，对CSS代码进行换行*/
</style>
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript">
	/* 显示和隐藏回复框  */
	var showAndHidden = function (k) {
		var div = document.getElementById("div"+k);
		if (div.style.display == 'block') {
			div.style.display = 'none';
		} else {
			div.style.display = 'block';
		}
	}
	
	/* 评论项目或楼层 */
	var returnLw= function(k){
		if("<%=session.getAttribute("identity")%>" == "null" || "<%=session.getAttribute("identity")%>" == "" ){
			var msg="请先登录再回复！是否前往登录？"
			if(confirm(msg)){
				window.location.href="<%=basePath%>/login/goToLogin.do"; 
				return
			}else{
				return;
			}
		}
		$.ajax({
			url : "<%=basePath%>/leaveword/addLeaveWordByUser.do",
			data : $('#rFrom'+k).serialize(),
			type : "Post",
			dataType : "text",
			success : function (data){
				listLeaveWord();
			},
			error : function (data){
				alert("评论失败");
			}
		});
	}
	
	/* 获取评论数据 */
	var listLeaveWord=function(){
		$.ajax({
			url : "<%=basePath%>/leaveword/listLeaveWord.do",
			data : {
				id : ${researchProject.id}
			},
			type : "get",
			dataType : "json",
			success : function (data){
				var content = document.getElementsByName("content");
				for(var i=0;i<content.length;i++){
					content[i].value="";
				}
				addHtml(data);
			},
			error : function (data){
				alert("获取评论失败");
			}
		});
	}
	
	var addHtml=function(data){
		var htmlStr="";
		var myobj=eval(data);
		var k=0;
		if(myobj.length>0){
			for(var i=0;i<myobj.length;i++){
				/* 判断是否为楼层 */
				if(myobj[i].parentId == '0'){
					k++;
					htmlStr+="<hr style='background-color: gray;height: 2px;'><table width='100%' style='margin-left: 0'>"+
					"<tr>"+
						"<td width='3%'><font size='1px'>第"+k+"楼</font></td>"+
						"<td align='right'><font size='1px'>"+myobj[i].byUserName+"</font></td>"+
					"</tr><tr>"+
						"<td width='50%'><font size='1px'>"+myobj[i].content+"</font></td>"+
					"</tr><tr>"+
						"<td width='3%'><font size='1px'>"+getLocalTime(myobj[i].createTime)+"</font></td>"+
						"<td width='3%' align='right'><a href='javascript:showAndHidden("+k+");'>回复该楼</a></td>"+
					"</tr></table>";
					for(var j=0;j<myobj.length;j++){
						if(myobj[j].parentId == myobj[i].id){
							htmlStr+="<hr><table width='100%' style='margin-left: 0'>"+
							"<tr>"+
								"<td width='3%'><font size='1px'>回复"+k+"楼</font></td>"+
								"<td align='right'><font size='1px'>"+myobj[j].byUserName+"</font></td>"+
							"</tr><tr>"+
								"<td width='50%'><font size='1px'>"+myobj[j].content+"</font></td>"+
							"</tr><tr>"+
								"<td width='3%'><font size='1px'>"+getLocalTime(myobj[j].createTime)+"</font></td>"+
							"</tr></table>";
						}
					}
					/* 显示或隐藏某楼的回复框 */
					htmlStr+="<div id='div"+k+"' style='display:none;'>"+
					"<form id='rFrom"+k+"'>"+
					"<hr>"+
					"<tr><td><font size='1px'>请输入回复内容:</font></td></tr>"+
					"<tr>"+
					"<td><input type='text' value='' style='width: 100%;font-size: 2px' id='content' name='content'></td>"+
					"<td><input type='hidden' id='parentId' value='"+myobj[i].id+"' name='parentId'></td>"+
					"<td><input type='hidden' id='forResearchId' value='${researchProject.id}' name='forResearchId'></td>"+
					"<td><input type='hidden' id='forResearchName' value='${researchProject.name}' name='forResearchName'></td>"+
					"</tr><tr><td align='right'>"+
					"<input onclick='javascript:returnLw("+k+");' type='button' value='确定回复'>"+
					"</td></tr>"+
					"</form></div>";
				}
			}
		}else{
			htmlStr="<tr><td>暂无相关评论</td></tr>";
		}
		$("#all").html(htmlStr);
	}
	
    $(document).ready(function() {
    	listLeaveWord();
    	if("<%=session.getAttribute("identity")%>" == "null" || "<%=session.getAttribute("identity")%>" == "" ){
			$("#down-div").hide();
			$("#drop-div").hide();
    	}
	});
    
    function  getLocalTime(nS){    
        return new  Date(parseInt(nS)).toLocaleString().replace('/:\ d {1,2} $ /','' );     
	}  
</script>
</head>
<body>
	<h3 align="center">${researchProject.name}</h3>
	<hr style="width: 60%; overflow: hidden; margin: 0 auto">
	<div style="width: 60%; overflow: hidden; margin: 0 auto" id="drop-div">
		<h5 align="right">
			<a href="<%=basePath%>/login/dropLogin.do">退出登录 </a>
		</h5>
	</div>
	<div style="width: 60%; overflow: hidden; margin: 0 auto">
		<h5 align="right">
			<a href="<%=basePath%>/researchproject/backresearchproject.do">返回项目列表
			</a>
		</h5>
	</div>
	<div style="width: 60%; overflow: hidden; margin: 0 auto" id="down-div">
		<h5 align="left">
			<a
				href="<%=basePath %>/researchproject/downPhotoById?rCode=${researchProject.rCode}">下载附件</a>
		</h5>
	</div>
	<div style="width: 60%; overflow: hidden; margin: 0 auto">
		<h5 align="left">
			<a target="_blank" href="${teacherQqUrl}"><img border="0"
				src="${teacherQqSrc}" alt="联系老师" title="联系老师" /></a>
		</h5>
	</div>
	<div style="width: 60%; overflow: hidden; margin: 0 auto;">
		<font size="1px">发布时间:<fmt:formatDate
				value="${researchProject.createTime}" pattern="yy-MM-dd hh:mm:ss" /></font>
	</div>
	<div style="width: 60%; overflow: hidden; margin: 0 auto">
		<font size="1px">${researchProject.content}</font>
	</div>
	<hr style="background-color: gray; height: 2px; width: 60%">
	<form id="rFrom0">
		<table align="center" width="60%">
			<tr>
				<td><font size="1px">请输入回复内容:</font></td>
			</tr>
			<tr>
				<td><input type="text" style="width: 100%; font-size: 20px"
					id="content" name="content"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="0" id="parentId"
					name="parentId"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="${researchProject.id}"
					id="forResearchId" name="forResearchId"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="${researchProject.name}"
					id="forResearchName" name="forResearchName"></td>
			</tr>
			<tr>
				<td><input type="button" onclick="javascript:returnLw(0);"
					value="确定回复"></td>
			</tr>
		</table>
	</form>
	<div style="width: 60%; overflow: hidden; margin: 0 auto" id="all">
	</div>

</body>
</html>