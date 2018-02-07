<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>로그인 페이지</title></head>
<body>
	<h1>로그인 페이지</h1>
	
	<!-- HTTP Method 중 post 방식으로 UsersServlet에 정보를 전달 (쿼리문자열을 사용할 수 없음) -->
	<form action="<c:url value='/UsersServlet' />" method="post">	<!-- insert에 해당하는 HTTP Method는 post -->
		<input type="hidden" name="cmd" value="CMD_LOGIN">
		<label>이메일 : <input type="email" name="email"></label><br>
		<label>비밀번호 : <input type="password" name="password"></label><br>
		<input type="submit" value="로그인">
	</form>
	<c:if test="${ param.error == 'matches' }">
		<div style="color: #FF0000">존재하지 않는 사용자이거나 패스워드가 잘못되었습니다.</div>
	</c:if>
	
	<!--
		SQL문	HTTP Method
		SELECT	GET
		INSERT	POST
		UPDATE	PUT		html에서는 POST	-> javascript ajax에서 PUT을 사용
		DELETE	DELETE	html에서는 POST -> javascript ajax에서 DELETE을 사용
	-->
</body>
</html>