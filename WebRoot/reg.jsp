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

<title>My JSP 'reg.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	//onload事件
	$(function() {
		$("#btn").click(function(){
			//获得手机号
			var tel_no=$("#tel").val();
			//ajax请求
			 $.get("user/code", {
				tel : tel_no
			}, function(data) {
				alert("Data Loaded: " + data);
			});
		
		});
 
 
 	$("#results").append( "<tt>" + $("form").serialize() + "</tt>" );
	});
</script>
</head>

<body>
	<p id="results"><b>Results: </b> </p>
	
	<form action="user/reg">
		用户名:<input name="username" id="name" /><br> 
		密码:<input name="userpassword" id="pwd" /><br> 
		确认密码:<input name="rePwd" id="rePwd" /><br>
		验证手机:<input name="tel" id="tel" /><br> 
		获取验证码:<input name="usercode" id="code" /><input type="button" id="btn" value="获取验证码" /><br>
		<input type="submit" value="注册" />
	</form>
</body>
</html>
