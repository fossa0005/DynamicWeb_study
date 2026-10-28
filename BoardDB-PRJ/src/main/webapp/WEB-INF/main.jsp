<%@page import="com.ssafy.prj.login.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
Login login = (Login)session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h2>환영합니다!</h2>
	<div>
		<%
		if (login == null) {
		%>
		<a href = "/Board-PRJ/login?act=loginForm" style="color : rgb(192, 192, 192);"> 로그인 </a>
		<a href = "/Board-PRJ/login?act=loginForm" style="color : rgb(192, 192, 192);"> 회원가입 </a>
		
		<% 
		} else { %>
		<a href = "/Board-PRJ/board?act=list" style="color : aqua;"> 자유게시판</a>
		<a href = "/Board-PRJ/login?act=logout" style="color : rgb(192, 192, 192);"> 로그아웃 </a>
		<%
		} 
		%>
	</div>
	
</body>
</html>