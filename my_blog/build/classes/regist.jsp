<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=">
<title>注册页面</title>
</head>
<body>
<form action="RegistServlet" method="post" style="padding-top:-700px">
用户名:<input type="text" value="name"  ><br><br>
输入密码:<input type="password" name="pwd"><br><br>
选择性别:<input type="radio" value="男" name="sex" checked>男
<input type="radio" value="女" name="sex">女<br><br>

选择家乡:
<select name="home">
  <option value="上海">上海</option>
  <option value="北京">北京</option>
  <option value="纽约" selected>纽约</option>
  <option value="南昌">南昌</option>
  
</select> 填写个人信息:<br>
<textarea rows="5" cols="30" name="info"></textarea><br>
<input type="reset"value="重置"><input type="submit"value="注册">  
</form>

</body>
</html>