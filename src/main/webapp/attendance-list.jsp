<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%//検索条件、検索結果を取得
List<AttendanceBean> attendanceList = (List) request.getAttribute("attendanceList");
String searchList = (String) request.getAttribute("searchList");
String from = (String) request.getAttribute("from");

//この記述がないとlist.jspからサーバー起動できない
if (attendanceList == null) {
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

<body>
	<main>
		<div class="Wrapper">
			<div class="main">
				<div class="main__listTitle">
					<h3>(^^)＜今日も1日ご安全に！</h3>
					<h2>勤怠一覧</h2>
				</div>
				<div class="main__search">
					<form action="AttendanceListServlet" method="post">
						<input type="date" name="date">
						<button type="submit" name="button" value="検索">検索</button>
					</form>
					<!-- 検索結果の表示 -->
					<!-- ボタン押下時に中身が空でなければ以下の処理が始まる -->
					<%
					if ("search".equals(from)) {
					%>
					<%=searchList%>
					<%
					} else {
					//out.print(attendanceList);
					}
					%>
					<%%>
				</div>
				<div class="main__listBox">
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
									<td><button type="submit">削除</button></td> <input type="hidden"
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
					<div class="footer">
						<a href="menu.jsp">メニュー画面へ戻る</a>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>