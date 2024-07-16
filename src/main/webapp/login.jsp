<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String errorMessage = (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ログイン画面</title>
</head>
<body>
	(^^)＜今日も1日ご安全に！
	<h1>ログイン</h1>
	<%
	if (errorMessage != null) {
	%>
	<p style="color: red"><%=errorMessage%></p>
	<%
	}
	%>

	<form action="login" method="post">
		<label for="userId">ユーザーID</label><br /> 
		<input type="text" required name="userId" id="userId" /><br />
		<label for="password">パスワード</label><br />
		<input type="password" required name="password" id="password" /><br />
		<input type="submit" value="ログイン" />
	</form>
</body>
</html>
