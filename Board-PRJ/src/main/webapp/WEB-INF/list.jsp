<%@page import="com.ssafy.prj.board.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.ssafy.prj.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%  
BoardDao dao = new BoardDao();
List<Board> boards = dao.selectBoard();
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<h2>자유게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
		</tr>
		
		<%
		for (Board board: boards) { 
		%>
		<tr>
			<td><%= board.getNo() %></td>
			<td><a href="/Board-PRJ/board?act=detail&no=<%=board.getNo()%>"><%=board.getTitle() %></a> </td>
			<td><%= board.getWriter() %></td>
			<td><%= board.getViewCnt() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>