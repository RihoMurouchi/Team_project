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
<title>勤怠編集画面</title>
</head>
<body>
	<div>
		<h1>勤怠編集</h1>
		<form action="editAttendance" method="post">
			<!-- 			<div> -->
			<!-- 				<p> -->
			<%-- 					名前：<%=attendance.getName()%></p> --%>
			<!-- 			</div> -->
<!-- 			<div> -->
				<label for="date">date</label>
				<textarea name="date" id="date"><%=attendance.getDate()%></textarea>
<!-- 			</div> -->
			<div>
				<button type="submit">更新</button>
				<input type="hidden" name="id" value="<%=attendance.getId()%>">
				<a href="attendanceList.jsp">戻る</a>
			</div>
		</form>
	</div>
</body>
</html>