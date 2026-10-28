<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<hr>
	<form action="/Board-PRJ/login">
		<input type="hidden" name="act" value="login"> 	
		<div>
			<label>ID :</label>
			<input type="text" name="id" />
		</div>
		<div>
			<label>PASSWORD :</label>
			<input type="password" name="password" />
		</div>
		<div style="color: gray; font-size:small;">
			사용자1 : maria / 1111<br>
			사용자2 : fossa / 1111<br>
			관리자 : admin / 1111<br>
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
	
	<script type="text/javascript">
		<% if("fail".equals(request.getAttribute("login"))) { %>
			alert("아이디 또는 비밀번호가 틀렸습니다");
		<% } %>
	</script>
</body>
</html>