<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
AttendanceBean attendance = (AttendanceBean) request.getAttribute("attendance");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
	<div>
		<h1>確認画面</h1>
		<form action="register-comp" method="post">
			<div>
				<label for="date">日付:</label>
				<id="date"><%=attendance.getDate()%> <input type="hidden" name="date" value="<%=attendance.getDate()%>">
			</div>
			<div>
				<label for="startTime">開始時間:</label>
				<id="startTime"><%=attendance.getStartTime()%> <input type="hidden" name="startTime" value="<%=attendance.getStartTime()%>">
			</div>
			<div>
				<label for="endTime">終了時間:</label>
				<id="endTime"><%=attendance.getEndTime()%> <input type="hidden"name="endTime" value="<%=attendance.getEndTime()%>">
			</div>
			<div>
				<label for="overTime">残業時間:</label>
				<id="overTime"><%=attendance.getOverTime()%> <input type="hidden" name="overTime" value="<%=attendance.getOverTime()%>">
			</div>
			<div>
				<button type="submit">確定する</button>
				<input type="hidden" name="userId" value="<%=attendance.getUserId()%>">
			</div>
			<div>
				<a href="register-confirm">戻る</a>
			</div>
		</form>
	</div>
</body>
</html>