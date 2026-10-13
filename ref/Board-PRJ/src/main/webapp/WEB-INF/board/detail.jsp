<%@page import="com.ssafy.prj.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Board board = (Board)request.getAttribute("board");
%>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<h2>자유게시판</h2>
	<div>
		<span>번호</span>
		<span><%= board.getNo() %></span>
	</div>
	<div>
		<span>제목</span>
		<span><%= board.getTitle() %></span>
	</div>
	<div>
		<span>글쓴이</span>
		<span><%= board.getWriter() %></span>
	</div>
	<div>
		<span>조회수</span>
		<span><%= board.getViewCnt() %></span>
	</div>
	<div>
		<a href="<%= request.getContextPath() %>/board?act=delete&no=<%= board.getNo() %>">삭제</a>
		<a href="<%= request.getContextPath() %>/board">목록</a>
	</div>
</body>
</html>













