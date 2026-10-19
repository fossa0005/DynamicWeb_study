<%@page import="com.ssafy.prj.board.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
<title>자유게시판</title>
<style type="text/css">
</style>
</head>
<body>
	<header>
		<div>
			<h2>자유게시판</h2>
		</div>
		<div>
			<nav>
				<div>
					<a class="logoutLink" href="${pageContext.request.contextPath}/login?act=logout">로그아웃</a>
				</div>
			</nav>
		</div>
	</header>
	
	
	<table class="boardTable">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
		</tr>
		
		<%
		List<Board> boards = (List<Board>)request.getAttribute("boards");
		
		for (int i=boards.size()-1; i>=0; i--) {
			Board board = boards.get(i);
		%>
		<tr>
			<td><%= board.getNo() %></td>
			<td style="text-align: left"><a class="titleLink" href="/Board-PRJ/board?act=detail&no=<%=board.getNo()%>"><%=board.getTitle() %></a> </td>
			<td><%= board.getWriter() %></td>
			<td><%= board.getViewCnt() %></td>
		</tr>
		<%
		}
		%>
	</table>
	
	<div class="underMenu">
		<div>
		</div>
		<div>
			<a class= "writeLink" href= "<%=request.getContextPath() %>/board?act=writeForm">게시글 작성</a>
		</div>
	</div>
	
</body>
</html>