<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>saveForm</title>
</head>
<body>
	
	<form action="/board/save" method="post">
		<input type="text" name="boardWriter" 	placeholder="작성자" />
		<input type="text" name="boardPass" 	placeholder="비밀번호" />
		<input type="text" name="boardTitle" 	placeholder="제목" />
		<textarea name="boardContents" cols="30" rows="10" placeholder="내용을 입력하세요"></textarea>
		<input type="submit" value="작성"/>
	</form>
	
</body>
<script>
	
</script>
</html>