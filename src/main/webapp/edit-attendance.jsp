<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
AttendanceBean attendance = (AttendanceBean) request.getAttribute("attendance");
UserBean user = (UserBean) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠編集画面</title>
</head>
<body>
	<div>
		<h1>勤怠編集</h1>
		<form action="edit-attendance" method="post">
			<!-- 			<div> -->
			<!-- 				<p> -->
			<%-- 					名前：<%=attendance.getName()%></p> --%>
			<!-- 			</div> -->
			<div>
				<label for="date">date</label>
				<textarea name="date" id="date"><%=attendance.getDate()%></textarea>
				<label for="startTime">startTime</label>
				<textarea name="startTime" id="startTime"><%=attendance.getStartTime()%></textarea>
				<label for="endTime">endTime</label>
				<textarea name="endTime" id="endTime"><%=attendance.getEndTime()%></textarea>
				<label for="overTime">overTime</label>
				<textarea name="overTime" id="overTime"><%=attendance.getOverTime()%></textarea>
			</div>
			<div>
				<button type="submit">変更</button>
				<input type="hidden" name="id" value="<%=attendance.getId()%>">
				<a href="attendance-list?id=<%=attendance.getId()%>">戻る</a>
			</div>
		</form>
	</div>
</body>
</html>