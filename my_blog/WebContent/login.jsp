<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=">
<title>登录界面</title>
</head>
<body>
<form action="LoginServlet" method="post" style="padding-top:-700px">
用户名<input type="text" name="name" value=""><br><br>
密码<input type="text" name="pwd" value=""><br><br>

<input type="submit" value="登录" name="login">
<input type="reset" value="重置" name="reset"><br> 
</form>

<form action="regist.jsp">
<input type="submit" value="注册"> 
</form>
</body>
</html>