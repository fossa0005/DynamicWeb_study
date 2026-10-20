<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
<title>게시글 수정</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/board">
		<input type="hidden" value="update">
		<div>
			<input type="text" class="titleForm" name="title">
		</div>
		<div>
			<input type="text" class="contentForm" name="content">
		</div>
	<button type="submit">수정하기</button>
	</form>
</body>
</html>