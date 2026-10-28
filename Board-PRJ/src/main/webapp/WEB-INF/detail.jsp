<%@ page import="com.ssafy.prj.board.Board" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% Board board = (Board)request.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
<title><%= request.getParameter("no") %>번째 게시글</title>
</head>
<body>
	<table class="detailTable">
		<tr>
			<td colspan="2"> <h3><%=board.getTitle()%></h3>  </td>
		</tr>
		<tr>
			<td><b>작성자</b> <%= board.getWriter()%></td>
			<td><b>조회수</b> <%= board.getViewCnt()%></td>
		</tr>
		<tr id= "contentBox">
			<td colspan="2"> <%= board.getContent()%></td>
		</tr>
	</table>
	
	<div class="underMenu">
		<div>
			<a href = "/Board-PRJ/board?act=list">목록으로</a>
		</div>
		<div>
			<!-- jstl 조건문 -->
			<c:if test="${sessionScope.login.id == board.writer}"> 
				<a href = "/Board-PRJ/board?act=updateForm&no=${board.no}">수정</a>
			|
			</c:if>
			
			<c:if test="${sessionScope.login.id == board.writer or sessionScope.login.id == 'admin'}">
				<a href = "/Board-PRJ/board?act=delete&no=${board.no}" onclick="return confirm('이 게시글을 삭제할까요?')">삭제</a>
				<!--  onclick: 클릭 시 자바스크립트 실행. 반환값이 false이면 a태그 실행하지않음 -->
				<!--  confirm: 사용자 선택 따라 true 또는 false 반환 -->
			</c:if>
		</div>
	</div>
		
</body>
</html>