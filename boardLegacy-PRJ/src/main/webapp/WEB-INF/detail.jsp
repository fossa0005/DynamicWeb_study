<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
<title>${board.title}</title>
</head>
<body>
	<div>
		<table class="detailTable">
			<tr>
				<td colspan="2"><h3>${board.title}</h3></td>
			</tr>
			<tr>
				<td><b>작성자 </b>${board.writer}</td>
				<td><b>조회수 </b>${board.viewCnt}</td>
			</tr>
			<tr class="contentBox">
				<td colspan="2">${board.content}</td>
			</tr>
		</table>
	</div>
	<div class="underMenu">
		<div>
			<a href="${pageContext.request.contextPath}/board">목록으로</a>
		</div>
		<div>
		</div>
	</div>
</body>
</html>