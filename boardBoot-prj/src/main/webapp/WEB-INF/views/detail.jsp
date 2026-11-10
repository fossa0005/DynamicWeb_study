<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.title}</title>
</head>
<body>

		<div class="underMenu">
			<c: if test="${board.writer == sesisonScope.login.id}">
				<a href="${pageContext.request.getContextPath}/updateForm">수정</a>
			|
			</c:>
			<c: if test="${board.writer == sesisonScope.login.id || 'admin' == sessionScope.login.id}"> 
				<a href="${pageContext.request.getContextPath}/delete?no=${board.no}">삭제</a>
			</c:>
		</div>

</body>
</html>