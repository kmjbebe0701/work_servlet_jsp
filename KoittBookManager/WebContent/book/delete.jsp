<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	<!-- JSTL 사용 -->
<!DOCTYPE html>
<html>
<head><title>도서 삭제 결과</title></head>
<body>
	<h1>도서 삭제 결과</h1><br>
	<h2>해당 도서가 삭제되었습니다.</h2><br>

	<a href="<c:url value='/BookServlet?cmd=CMD_LIST' />">도서 목록으로 이동</a>
</body>
</html>