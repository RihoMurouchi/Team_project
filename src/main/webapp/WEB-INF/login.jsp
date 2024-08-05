<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css/main.css">
<title>ログイン画面</title>
</head>
<body>
	<main>
		<div class="main">
			<div class="wrapper">
				<div class="main__box">
					(^^)＜今日も1日ご安全に！
					<h1>ログイン</h1>
					<%
					if (error != null) {
					%>
					<p class="err"><%=error%></p>
					<%
					}
					%>

					<form action="login" method="post">
						<label for="userId">ユーザーID</label><br />
						<!------------------- pattern属性で数字のみの入力を許可し、title属性で説明を追加 ---------------------->
						<input class="main__textBox" type="text" required name="userId" id="userId" pattern="\d*" title="数字のみを入力してください。" /><br /> <label
							for="password">パスワード</label><br /> <input class="main__textBox" type="password" required name="password" id="password" /><br />
						<button class="main__button" type="submit">ログイン</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>
