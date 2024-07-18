<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<AttendanceBean> attendanceList = (List) request.getAttribute("attendanceList");
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
<title>勤怠一覧画面</title>
</head>
]
<body>
	(^^)＜今日も1日ご安全に！
	<h1>勤怠一覧</h1>
	<a href="menu.jsp">メニューへ</a>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<!-- 				<th>userid</th> -->
				<th>day</th>
				<th>strat</th>
				<th>end</th>
				<th>over</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (AttendanceBean attendance : attendanceList) {
			%>
			<tr>
				<td><%=attendance.getId()%></td>
				<%-- 				<td><%=attendance.getUserId()%></td> --%>
				<td><%=attendance.getDate()%></td>
				<td><%=attendance.getStartTime()%></td>
				<td><%=attendance.getEndTime()%></td>
				<td><%=attendance.getOverTime()%></td>
				<!-- 編集と削除のリンク -->
				<td><a href="edit-attendance?id=<%=attendance.getId()%>">編集</a></td>
				<form action="delete-attendance" method="post">
					<td><button type="submit">削除仮</button></td> <input type="hidden"
						name="id" value="<%=attendance.getId()%>">
				</form>
				<!-- 				<td><a -->
				<%-- 					href="delete-attendance-confirm?id=<%=attendance.getId()%>">削除</a></td> --%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>