<%@page import="com.ssafy.prj.login.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Login login = (Login)session.getAttribute("login");
%>	
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>메인</title>
</head>
<body>
	<h2>메인 페이지</h2>
	<div>
		<%
		if (login == null) {
		%>
			<a href="<%= request.getContextPath() %>/login?act=loginForm">로그인 이동</a>
			<a href="<%= request.getContextPath() %>/login?act=loginForm">회원가입 이동</a>
		<%
		} else {
		%>
			<a href="<%= request.getContextPath() %>/board">자유 게시판 이동</a>
			<a href="<%= request.getContextPath() %>/login?act=logout">로그아웃</a>
		<%
		}
		%>
	</div>
</body>
</html>