<%@ page import="com.ssafy.prj.board.Board" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getParameter("no") %>번째 게시글</title>
</head>
<body>
	<h2><%= board.getTitle() %></h2>
	<hr>
	<b>작성자 </b><%= board.getWriter()%> <b>조회수</b><%= board.getViewCnt() %>
	<hr>
	<p><%= board.getContent()%></p>
	<a href = "/Board-PRJ/board?act=list">목록으로</a>	
</body>
</html>