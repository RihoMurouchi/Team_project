<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
AttendanceBean attendance = (AttendanceBean) request.getAttribute("attendance");
String error = (String) request.getAttribute("error");
UserBean user = (UserBean) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<title>勤怠編集画面</title>
</head>
<body>
	<div>
		<h1>勤怠編集</h1>
		<div>
			<%if (attendance == null) {%>

			<p class="err"><%=error%></p>

			<form action="attendance-list" method="post">
				<input class="main__button" type="submit" name="button" value="勤怠一覧へ">
			</form>

			<%
			} else {
			%>
			<form action="edit-attendance" method="post">
				<label for="date">date</label> <input type="date" name="date" id="date"
					value='<%=attendance.getDate()%>' required> <label for="startTime">startTime</label> <input
					type="time" name="startTime" id="startTime" value='<%=attendance.getStartTime()%>' required>
				<label for="endTime">endTime</label> <input type="time" name="endTime" id="endTime"
					value='<%=attendance.getEndTime()%>' required> <label for="overTime">overTime</label> <input
					type="time" name="overTime" id="overTime" value='<%=attendance.getOverTime()%>' required>
		</div>
		<div>
			<button class="main__button" type="submit">変更</button>
			<input type="hidden" name="id" value="<%=attendance.getId()%>">
		</div>
		</form>
		<div>
			<button class="main__button" type="button" onclick="history.back()">戻る</button>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>