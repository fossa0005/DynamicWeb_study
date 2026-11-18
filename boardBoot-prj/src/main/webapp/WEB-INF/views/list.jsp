<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/Style.css">
<title>자유게시판</title>
</head>

<body>
	<table class="boardTable">
		<colgroup>
			<col style="width: 8%">
			<col style="width: 44%">
			<col style="width: 15%">
			<col style="width: 25%">
			<col style="width: 8%">
		</colgroup>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boards}">
		<tr>
			<td>${board.no}</td>
			<td style="text-align: left">${board.title}</td>
			<td>${board.writer}</td>
			<td>${board.regDate}</td>
			<td>${board.viewCnt}</td>
		</tr>
		</c:forEach>
	</table>
	
	<div class="underMenu">
		<div>
			<a href="${pageContext.request.contextPath}/writeForm">게시글작성</a>
		</div>
	</div>

</body>
</html>
