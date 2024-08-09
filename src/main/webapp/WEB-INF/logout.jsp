<%@page import="model.entity.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
UserBean user = (UserBean) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/footer.css">
<title>ログアウト画面</title>
</head>
<body>
	<main>
		<div class="main">
			<div class="main__box">
				<%=user.getName()%>さん、お疲れ様でした＼(^o^)／ <br>
			</div>
		</div>
	</main>
	<footer class="footer">
		<form action="login" method="get">
			<input class="main__button" type="submit" name="button" value="ログイン画面へ">
		</form>
	</footer>
</body>
</html>