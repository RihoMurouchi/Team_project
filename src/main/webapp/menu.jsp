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
			<div class="main__transition">
				<h2>めにゅうがめん(・∀・)</h2>
				<form action="menu" method="post">
					<input type="submit" name="button" value="きんたいいちらん"><br>
					<input type="submit" name="button" value="とうろくがめん"><br>
				</form>
			</div>
			<div class="main__logout">
				<form action="byebye" method="post">
					<input type="submit" name="button" value="ろぐあうと">
				</form>
			</div>
	</main>
</body>
</html>
