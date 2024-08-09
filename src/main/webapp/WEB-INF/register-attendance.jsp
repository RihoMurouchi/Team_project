<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<title>勤怠登録</title>
</head>
<body>
	<main>
		<div class="main">
			<div class="main__box">
				<h2>勤怠登録</h2>
				<div class="main__registerBox">
					<form action="register-confirm" method="post">
						<div>
							<label for="date">日付</label><br> <input type="date" name="date" id="date" required>
						</div>
						<div>
							<label for="start">勤務開始</label><br> <input type="time" name="start" id="start" required>
						</div>
						<div>
							<label for="end">勤務終了</label><br> <input type="time" name="end" id="end" required>
						</div>
						<div>
							<label for="over">残業時間</label><br> <input type="time" name="over" id="over" required>
						</div>
						<div>
							<input type="submit" name="button" value="確認画面へ"><br>
						</div>
					</form>
				</div>
				<div>
					<form action="attendance-list" method="post">
						<input class="main__button" type="submit" name="button" value="一覧画面へ">
					</form>
					<form action="menu" method="get">
						<input class="main__button" type="submit" name="button" value="メニューへ">
					</form>
				</div>
			</div>
		</div>
		</div>
	</main>
</body>
</html>
