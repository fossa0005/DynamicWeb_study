<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/Style.css">
<title>게시글 작성</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/write" method="POST" onsubmit="return isValidate()">
		<div>
			<input type="hidden" name="memberId" value="${SessionScope.loginMember.memberId}">
		</div>
		<div>
			<input type="text" class="titleForm" id="title" name="title" placeholder="제목">
		</div>
		<div>
			<textarea class="contentForm" id="content" name="content" placeholder="내용을 입력하세요"></textarea>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
	
	<script type="text/javascript">
		function isValidate() {
			//value: 사용자로부터 입력받은 값
			//trim() : 공백문자 제거
			const title = document.querySelector("#title").value.trim(); 
			const content = document.querySelector("#content").value.trim();
			
			if(title == "") {
				alert("제목을 입력하세요");
				return false;
			}
			
			if(content == "") {
				alert("내용을 입력하세요");
				return false;
			}
			
			return true;
		}
	</script>
</body>
</html>