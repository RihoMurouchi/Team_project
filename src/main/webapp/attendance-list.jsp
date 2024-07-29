<%@page import="model.entity.*"%>
<%@page import="model.dao.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%//検索条件、検索結果を取得%>
<%
List<AttendanceBean> attendanceList = (List) request.getAttribute("attendanceList");
List<AttendanceBean> searchList = (List) request.getAttribute("searchList");
String from = (String) request.getAttribute("from");
String error = (String) request.getAttribute("error");
%>

<%
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
<link rel="stylesheet" href="css/main.css">
<title>勤怠一覧画面</title>
</head>
<body>
	<main>
		<div class="Wrapper">
			<div class="main">
				<div class="main__listTitle">
					<marquee behavior="scroll">
						<h3>お疲れ様です！⊂二（＾ω＾ ）二二⊃ﾌﾞｰﾝ</h3>
					</marquee>
					<h2>勤怠一覧</h2>
				</div>
				<div class="main__search">
					<form action="attendance-list" method="post">
						<label for="date"></label><br> <input type="date" name="date"
							id="date" required> <input class="main__button"
							type="submit" name="searchButton" value="検索"><br>
						</button>
					</form>
				</div>
				<!-- 検索結果の表示 -->
				<div class="main__searchResult">
					<%
					if ("search".equals(from)) {
					%>
					<%if (error != null || searchList.isEmpty()) {%>
					<p class="error"><%=error%></p>
					<%
					} else {
					%>
					<div class="main__listBox">
						<table>
							<thead>
								<tr>
									<th>id</th>
									<th>day</th>
									<th>strat</th>
									<th>end</th>
									<th>over</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (AttendanceBean attendanceSearch : searchList) {
								%>
								<tr>
									<td><%=attendanceSearch.getId()%></td>
									<td><%=attendanceSearch.getDate()%></td>
									<td><%=attendanceSearch.getStartTime()%></td>
									<td><%=attendanceSearch.getEndTime()%></td>
									<td><%=attendanceSearch.getOverTime()%></td>

									<td><a class="main__button"
										href="edit-attendance?id=<%=attendanceSearch.getId()%>">編集</a></td>
									<form action="delete-attendance" method="post">
										<td><button class="main__button" type="submit">削除</button></td>
										<input type="hidden" name="id"
											value="<%=attendanceSearch.getId()%>">
									</form>
								</tr>
								<%
								}
								%>
								<%
								}
								%>

							</tbody>
						</table>
						<div class="footer">
							<form action="attendance-list" method="post">
								<input class="main__button" type="submit" name="button"
									value="戻る">
							</form>
						</div>
						<%
						} else if (attendanceList != null) {
						%>
						<%if (attendanceList.size() == 0) {%>
						<p class="error">勤怠情報は登録されていません。</p>
						<div class="main__register">
							<form action="register-attendance.jsp" method="post">
								<input class="main__button" type="submit" name="button"
									value="勤怠登録"><br>
							</form>
						</div>
						<%
						} else {
						%>
						<div class="main__listBox">
							<table>
								<thead>
									<tr>
										<th>id</th>
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
										<td><%=attendance.getDate()%></td>
										<td><%=attendance.getStartTime()%></td>
										<td><%=attendance.getEndTime()%></td>
										<td><%=attendance.getOverTime()%></td>
										<!-- 編集と削除のリンク -->
										<td><a class="main__button"
											href="edit-attendance?id=<%=attendance.getId()%>">編集</a></td>
										<form action="delete-attendance" method="post">
											<td><button class="main__button" type="submit">削除</button></td>
											<input type="hidden" name="id"
												value="<%=attendance.getId()%>">
										</form>
									</tr>
									<%
									}
									%>
									<%
									}
									%>
								</tbody>
							</table>
							<div class="footer">
								<a class="main__button" href="menu.jsp">メニュー画面へ戻る</a>
							</div>
							<%
							}
							%>


						</div>

					</div>
				</div>
			</div>
	</main>
</body>
</html>