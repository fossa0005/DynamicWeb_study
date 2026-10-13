<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<hr>
	<form action="<%= request.getContextPath() %>/login" method="post">
		<input type="hidden" name="act" value="login" />
		<div>
			<label>ID : </label>
			<input type="text" name="id" />
		</div>
		<div>
			<label>PASS : </label>
			<input type="password" name="password" />
		</div>
		<div>
			<button>로그인</button>
		</div>
	</form>
	
</body>
</html>