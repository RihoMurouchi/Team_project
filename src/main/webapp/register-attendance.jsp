<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠登録</title>
</head>
<body>
	<div>
		<h1>勤怠登録</h1>
		<form action="register-attendance" method="post">
			<div>
				<label for="date">日付</label><br>
				<input type="date" name="date" id="date">
			</div>
			<div>
				<label for="start">勤務開始</label><br>
				<input type="time"  name="start" id="start"></textarea>
			</div>
			<div>
			    <label for="end">勤務終了</label><br>
				<input type="time" name="end" id="end"></textarea>
			</div>
			<div>
			    <label for="over">残業時間</label><br>
				<input type="time" name="over" id="over"></textarea>
			</div>
			<div>
				<button type="submit">確認画面へ</button><br>
				<a href="menu">戻る</a>
			</div>
		</form>
	</div>
</body>
</html>
