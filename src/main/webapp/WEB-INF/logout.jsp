<%@page import="model.entity.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
UserBean user = (UserBean) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
	<%=user.getName()%>さん、お疲れ様でした＼(^o^)／
	<br>
	<form action="login" method="get">
		<input class="main__button" type="submit" name="button" value="ログイン画面へ">
	</form>
</body>
</html>