<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session == null || session.getAttribute("user") == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<%
Integer count = (Integer) request.getAttribute("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠削除完了画面</title>
</head>
<body>

	<%
	if (count == 0) {
	%>
	<p class='error'>勤怠の削除に失敗しました。</p>

	<%
	} else {
	%>
	<%=count%>件の勤怠情報を削除しました。
	<%
	}
	%>
	<br>
	<form action="attendance-list" method="post">
		<input type="submit" name="button" value="勤怠一覧">
	</form>
</body>
</html>