<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠登録</title>
</head>
<body>
	<main>
		<div class="main">
			<div class="main__Wrapper">
				<h2>勤怠登録</h2>
				<div class="main__registerBox">
					<form action="register-attendance" method="post">
						<div>
							<label for="date">日付</label><br>
							 <input type="date" name="date" id="date">
						<div>
							<label for="start">勤務開始</label><br>
							 <input type="time" name="start" id="start">
						</div>
						<div>
							<label for="end">勤務終了</label><br>
							 <input type="time" name="end" id="end">
						</div>
						<div>
							<label for="over">残業時間</label><br>
							 <input type="time" name="over" id="over">
						</div>
					</form>
				</div>
				<div class="main__confirmation">
				   <form action="register-confirm" method="post">
						<input type="submit" name="button" value="確認画面へ"><br>
				   </form>
				</div>
				<div>
				<a href="menu.jsp">戻る</a>
				</div>
			</div>
		</div>
		</div>
	</main>
</body>
</html>
