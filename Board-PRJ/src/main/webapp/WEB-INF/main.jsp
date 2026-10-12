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
	<%if (login == null) %>
	<a href = "/Board-PRJ/login" style="color : aqua;"> 로그인 </a>
	<a href = "/Board-PRJ/login" style="color : aqua;"> 회원가입 </a>
	
	<%else { %>
	<a href = "/Board-PRJ/board" style="color : aqua;"> 자유게시판</a>
	<a href = "/Board-PRJ/login" style="color : aqua;"> 로그아웃 </a>
	<%} %>
</body>
</html>