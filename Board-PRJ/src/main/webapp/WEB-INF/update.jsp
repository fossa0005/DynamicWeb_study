<%@page import="com.ssafy.prj.board.Board"%>
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
	<!--패러미터를 히든타입 인풋 태그로 전달할수도 있음-->
	<form action="${pageContext.request.contextPath}/board">
		<input type="hidden" name="act" value="update">
		<input type="hidden" name="no" value="${board.no}">
		<div>
			<input type="text" class="titleForm" name="title" value="${board.title}">
		</div>
		<div>
			<textarea class="contentForm" name="content">${board.content}</textarea>
		</div>
	<button type="submit">수정하기</button>
	</form>
</body>
</html>