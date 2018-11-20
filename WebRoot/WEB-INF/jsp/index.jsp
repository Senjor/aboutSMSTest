<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!--引入bootstrap的css  -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<!--引入主题CSS  -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/bootstrap-theme.min.css">
<!--必须先引入jquery文件  -->
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.js"></script>
<!--引入bootstrap的核心js  -->
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<!--引入holder.js文件  -->
<script type="text/javascript" src="<%=path%>/js/holder.js"></script>


<script type="text/javascript">
	$(function(){
		//页面加载会执行	
		$("[type='button']").click(function(){
			//alert("添加操作");
			$(location).attr("href","toAdd");			
		});	
		
	});
	
	//刪除操作
	function doDel(id){
		var b=confirm("確認刪除嗎?");
		if(b){
			window.location='toDel?id='+id;
		}
	}
	
	//到更新頁面
	function doUpdate(id){
			window.location='toUp?id='+id;
	}
	
</script>
</head>

<body>
	<div class="container">
		<div class="page-header text-danger">
			<h1>用户列表页面</h1>
		</div>
		<button type="button" class="btn btn-warning">增加用户</button>
		<table class="table table-striped table-bordered table-hover">
			<tr>
				<th>序号</th>
				<th>用户编码</th>
				<th>用户名称</th>
				<th>用户密码</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${users }" var="u">
				<tr>
					<td>${u.id }</td>
					<td>${u.usercode }</td>
					<td>${u.username }</td>
					<td>${u.userpassword }</td>
					<td>
					<a href="javascript:doUpdate(${u.id})"><span class="glyphicon glyphicon-edit"></span>
					</a> 
					&nbsp;&nbsp;&nbsp; 
					<a href="javascript:doDel(${u.id})"><span
							class="glyphicon glyphicon-trash"></span>
					</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
