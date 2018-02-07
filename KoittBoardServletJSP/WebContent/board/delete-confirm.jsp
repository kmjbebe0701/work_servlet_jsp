<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>삭제 확인</title></head>
<body>
	<h1>삭제 확인</h1>
	<!-- 쿼리문자열의 no -->
	<h2>${ param.no }번 글을 삭제하시겠습니까?</h2>
	
	<!-- form 태그를 이용하여 서버로 post 전송 -->
	<form action="<c:url value='/BoardServlet' />" method="post">
		<input type="hidden" name="cmd" value="CMD_DELETE">
		<input type="hidden" name="no" value="${ param.no }">
		<input type="submit" value="예">
	</form>
	<a href="<c:url value='/BoardServlet?cmd=CMD_LIST'/>">글 목록으로 이동</a>
</body>
</html>