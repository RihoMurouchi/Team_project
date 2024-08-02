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
<link rel="stylesheet" href="css/main.css">
<title>勤怠情報削除画面</title>
</head>
<body>
	<div>
		<h1>勤怠情報削除確認</h1>
		<form action="delete-attendance-comp" method="post">
			<div>
				<label for="date">日付:</label>
				<id="date"><%=attendance.getDate()%> <input type="hidden"
					name="date" value="<%=attendance.getDate()%>">
			</div>
			<div>
				<label for="startTime">開始時間:</label>
				<id="startTime"><%=attendance.getStartTime()%> <input
					type="hidden" name="startTime"
					value="<%=attendance.getStartTime()%>">
			</div>
			<div>
				<label for="endTime">終了時間:</label>
				<id="endTime"><%=attendance.getEndTime()%> <input type="hidden"
					name="endTime" value="<%=attendance.getEndTime()%>">
			</div>
			<div>
				<label for="overTime">残業時間:</label>
				<id="overTime"><%=attendance.getOverTime()%> <input
					type="hidden" name="overTime" value="<%=attendance.getOverTime()%>">
			</div>
			<div>
				<button class="main__button" type="submit">確定</button>
				<input type="hidden" name="id" value="<%=attendance.getId()%>">
			</div>
		</form>
		<div>
			<button class="main__button" type="button" onclick="history.back()">戻る</button>
		</div>
	</div>

</body>
</html>