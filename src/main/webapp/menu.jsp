<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 	if (session == null || session.getAttribute("user") == null) {
// 		response.sendRedirect("login.jsp");
// 		return;
// 	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENU</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
<%-- 	<%@ include file="header.jsp"%> --%>
	<div class="main">
		<main>
			<h2>勤怠管理φ(｀д´)ﾒﾓﾒﾓ...</h2>
			<form action="menu" method="post">
				<input type="submit" name="button" value="勤怠一覧"><br>
				<input type="submit" name="button" value="勤怠登録画面へ"><br>
				<input type="submit" name="button" value="ログアウト">
			</form>
		</main>
	</div>
</body>
</html>
