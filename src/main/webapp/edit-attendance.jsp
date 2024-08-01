<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
AttendanceBean attendance = (AttendanceBean) request.getAttribute("attendance");
UserBean user = (UserBean) session.getAttribute("user");
%>
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
<title>勤怠編集画面</title>
</head>
<body>
	<div>
		<h1>勤怠編集</h1>
		<form action="edit-attendance" method="post">
			<div>
				<label for="date">date</label> <input type="date" name="date"
					id="date" value='<%=attendance.getDate()%>' required> <label
					for="startTime">startTime</label> <input type="time"
					name="startTime" id="startTime"
					value='<%=attendance.getStartTime()%>' required> <label
					for="endTime">endTime</label> <input type="time" name="endTime"
					id="endTime" value='<%=attendance.getEndTime()%>' required>
				<label for="overTime">overTime</label> <input type="time"
					name="overTime" id="overTime" value='<%=attendance.getOverTime()%>'
					required>
			</div>
			<div>
				<button type="submit">変更</button>
				<input type="hidden" name="id" value="<%=attendance.getId()%>">
			</div>
		</form>
		<div>
			<button type="button" onclick="history.back()">戻る</button>
		</div>
	</div>
</body>
</html>