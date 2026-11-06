<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
<title>자유게시판</title>
</head>
<body>
	<header>
		<div>
			<h2>자유게시판</h2>
		</div>
		<div>
			<nav>
			 	<div>
			 	 로그아웃
			 	</div>
			</nav>
		</div>
	</header>
	
	<main>
		<table class="boardTable">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="board" items="${boards}">
				<tr>
					<td>${board.no}</td>
					<td style="text-align: left"><a class="titleLink" href="${pageContext.request.contextPath}/board/detail/${board.no}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.viewCnt}</td>
				<tr>
			</c:forEach>
		</table>
	</main>

</body>
</html>
