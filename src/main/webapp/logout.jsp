<%@page import="model.entity.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%UserBean user = (UserBean)session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
	<%=user.getName() %>さん、お疲れ様でした＼(^o^)／<br>
	<a href="login.jsp">ログイン画面へ戻る</a>
</body>
</html>