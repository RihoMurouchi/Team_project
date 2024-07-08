<%@page import="model.entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%UserBean user = (UserBean)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
	<%=user.getUserId() %>さん、お疲れ様でした(/・ω・)/<br>
	<a href="login">ログイン画面</a>
</body>
</html>