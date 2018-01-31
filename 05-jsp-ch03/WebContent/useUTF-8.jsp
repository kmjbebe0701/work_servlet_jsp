<!-- p.64 -->
<!-- 
	인코딩 적용순서
	1. pageEncoding
	2. contentType
	3.모두 해당되지 않을 경우 ISO-8859-1 캐릭터 셋(character set)을 사용
 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="java.util.Date"%>
<% Date now = new Date(); %>
<!DOCTYPE html>
<html>
<head><title>현재시간</title></head>
<body>
현재시각:
<%=now %>
</body>
</html>