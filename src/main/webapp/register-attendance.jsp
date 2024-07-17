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
				<label for="title"></label><br>
				<input type="text" name="name" id="title">
			</div>
			<div>
				<label for="message">勤務開始</label><br>
				<textarea name="message" id="message"></textarea>
			</div>
			<div>
				<button type="submit">登録</button>
				<a href="tweet-list">戻る</a>
			</div>
		</form>
	</div>
</body>
</html>
