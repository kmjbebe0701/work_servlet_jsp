<!-- p.309 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<!-- http://search.daum.net/search?w=blog&q=공원 -->
	<c:url value="http://search.daum.net/search" var="searchUrl">
		<c:param name="w" value="blog" />
		<c:param name="q" value="공원" />
	</c:url>
	
	<ul>
		<li>${ searchUrl }</li>
		<li><c:url value="/use_if_tag.jsp" /></li>
		<li><c:url value="./use_if_tag.jsp" /></li>
	</ul>
</body>
</html>