<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int count = (Integer) request.getAttribute("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠編集完了画面</title>
</head>
<body>

	<%=count%>件の勤怠情報を変更しました。<br>

	<form action="edit-attendance-comp" method="post">
		<input type="submit" name="button" value="勤怠一覧">
	</form>

</body>
</html>