<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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

</head>

<body>
	<div class="container">
		<div class="page-header">
			<h1>添加頁面</h1>
		</div>
		<form action="update" method="get">
		<!--隱藏域存放用戶編號  -->
		<input type="hidden" name="id" value="${user.id }">
		<div class="form-group has-success">
			<label class="control-label" for="inputSuccess1">用戶編碼</label> 
			<input type="text" value="${user.usercode }" name="usercode" class="form-control" id="inputSuccess1">
		</div>
		<div class="form-group has-warning">
			<label class="control-label" for="inputWarning1">用戶名稱</label>
			 <input type="text" value="${user.username }" name="username" class="form-control" id="inputWarning1">
		</div>
		<div class="form-group has-error">
			<label class="control-label" for="inputError1">用戶密碼</label> 
			<input type="text" value="${user.userpassword }" name="userpassword" class="form-control" id="inputError1">
		</div>
		
		<input type="submit" class="btn btn-primary" value="修改" >
		<input type="reset" class="btn btn-primary" value="重置">
		</form>
	</div>
</body>
</html>
