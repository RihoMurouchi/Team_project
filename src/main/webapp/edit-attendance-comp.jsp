<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Integer count = (Integer) request.getAttribute("count");
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<title>勤怠編集完了画面</title>
</head>
<body>
	<%
	if (count == null || count == 0) {
	%>
	<p class='err'><%=error%></p>

	<%
	} else {
	%>
	<%=count%>件の勤怠情報を編集しました。
	<%
	}
	%>
	<br>
	<form action="attendance-list" method="post">
		<input class="main__button" type="submit" name="button" value="勤怠一覧へ">
	</form>
</body>
</html>