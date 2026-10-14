<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style type="text/css">
	 #content{
	 	margin: 10px;
	 	width : 500px;
	 	height : 300px;
	 }
	 
	 #title{
	 	margin : 10px;
	 	width : 500px;
	 }

</style>
</head>

<body>
	<form action="/Board-PRJ/board?act=write">
		<div>
			<input type="hidden" name="act" value="write" >
			<div>
				<input type="text" id="title" name="title" placeholder="제목을 입력하세요">
			</div>
			<div>
				<input type="text" id="content" name="content" placeholder="내용을 입력하세요">
			</div>
		</div>
		<button type="submit">게시하기</button>
	</form>
		
	
</body>
</html>