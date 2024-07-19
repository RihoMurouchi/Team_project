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
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
	<%-- 	<%@ include file="header.jsp"%> --%>
	<main>
		<div class="main">
			<div class="main__transitionBox">
				<h2>めにゅう(・∀・)</h2>
				<div class="main__menu">
					<form action="menu" method="post">
						<input type="submit" name="button" value="勤怠一覧"><br>
					</form>
				</div>
				<div class="main__register">
					<form action="register-attendance.jsp" method="post">
						<input type="submit" name="button" value="登録画面"><br>
					</form>
				</div>
				<div class="main__logout">
					<form action="byebye" method="post">
						<input type="submit" name="button" value="ログアウト">
					</form>
				</div>
			</div>
	</main>
</body>
</html>
