<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>자유 게시판</h2>
	<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
	</tr>
	<c:forEach var="board" items="${list}">
	<tr>
		<td>${board.no}</td>
		<td>${board.title}</td>
		<td>${board.writer}</td>
		<td>${board.regDate}</td>
	</tr>
	</c:forEach>
	</table>
	
	<div>
		<h2><a href="${pageContext.request.contextPath}/board/write">글쓰기</a></h2>
	</div>
</body>
</html>


