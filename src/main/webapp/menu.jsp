<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session == null || session.getAttribute("user") == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENU</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<%-- 	<%@ include file="header.jsp"%> --%>
	<main>
		<div class="main">
			<div class="wrapper">
				<h2>めにゅう(・∀・)</h2>
				<div class="main__menu">
					<form action="menu" method="post">
						<input class="main__button" type="submit" name="button" value="勤怠一覧"><br>
					</form>
				</div>
				<div class="main__register">
					<form action="register-attendance.jsp" method="post">
						<input class="main__button" type="submit" name="button" value="勤怠登録"><br>
					</form>
				</div>
				<div class="main__logout">
					<form action="logout.jsp" method="post">
						<input class="main__button" type="submit" name="button" value="ログアウト">
					</form>
				</div>
			</div>
	</main>
</body>
</html>
