<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>글 등록 페이지</title></head>
<body>
	<h1>글 등록 페이지</h1>
	<a href="<c:url value='/BoardServlet?cmd=CMD_LIST' />">글 목록</a>	<!-- 글 목록 화면으로 이동하는 하이퍼링크 -->
	
	<!-- HTTP Method 중 post 방식으로 BoardServlet에 정보를 전달 (쿼리문자열을 사용할 수 없음) -->
	<form action="<c:url value='/BoardServlet' />" method="post">	<!-- insert에 해당하는 HTTP Method는 post -->
		<input type="hidden" name="cmd" value="CMD_INSERT">
		<label>제목 : <input type="text" name="title"></label><br>
		<label>작성자 : <input type="text" name="writer"></label><br>
		<label>내용 : </label><textarea rows="3" cols="50" name="content"></textarea><br>
		<input type="submit" value="글 등록">
	</form>
	
	<!--
		SQL문	HTTP Method
		SELECT	GET
		INSERT	POST
		UPDATE	PUT		html에서는 POST	-> javascript ajax에서 PUT을 사용
		DELETE	DELETE	html에서는 POST -> javascript ajax에서 DELETE을 사용
	-->
</body>
</html>

