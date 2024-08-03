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
<title>勤怠登録完了</title>
</head>
<body>
	<main>
		<div class="main__registerCompBox">
			<h2>勤怠登録完了('◇')ゞ</h2>
			<div class="main__registerComp">
				<%
			if(count == null || count == 0){
			%>
				<p class='error'><%=error%></p>

				<%
			}else{
			%>
				<%=count%>件の勤怠情報を登録しました。
				<%
			}
			%>
				<form action="menu.jsp" method="post">
					<input type="submit" name="button" value="メニュー画面へ戻る">
				</form>
			</div>
		</div>
	</main>
</body>
</html>