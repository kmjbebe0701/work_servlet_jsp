<!-- p.304 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date"%>		<!-- Servlet 대신해서 JSP에서 표현 -->
<%@ page import="java.util.HashMap" %>	<!-- Servlet 대신해서 JSP에서 표현 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	<!-- JSTL 사용을 위해 선언 -->
<%
	// Servlet 대신해서 JSP에서 표현
	HashMap<String, Object> mapData = new HashMap<String, Object>();
	mapData.put("name", "최범균");
	mapData.put("today", new Date());
%>
<!-- var에 설정한 변수명에 value에 설정한 값을 넣는다. -->
<c:set var="intArray" value="<%= new int[]{1, 2, 3, 4, 5} %>" />
<c:set var="map" value="<%= mapData %>" />
<!DOCTYPE html>
<html>
<head><title>forEach 태그</title></head>
<body>
	<h4>1부터 100까지 홀수의 합</h4>
	<c:set var="sum" value="0" />
	<!-- 변수 i가 1부터 100까지 2씩 증가 -->
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum" value="${ sum + i }" />
	</c:forEach>
	결과 = ${ sum }
	
	<h4>구구단: 4단</h4>
	<ul>
		<!-- 변수 i가 1에서 9까지 1씩 증가 -->
		<c:forEach var="i" begin="1" end="9">
			<li>4 * ${ i } = ${ 4 * i }</li>
		</c:forEach>
	</ul>
	
	<h4>int형 배열</h4>
	<!-- intArray[i] 값을 i에 저장해서 사용 -->
	<c:forEach var="i" items="${ intArray }" begin="2" end="4" varStatus="s">
		${ s.index }-${ s.count }-[${ i }]<br> 
	</c:forEach>
	
	<h4>Map</h4>
	<c:forEach var="i" items="${ map }">
		${ i.key } = ${ i.value }<br>
	</c:forEach>
</body>
</html>




