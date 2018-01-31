<!-- p.123 -->
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head><title>초기화 파라메터 읽어오기</title></head>
	<body>

	초기화 파라메터 목록:
		<ul>
			<%
				//JSP에서 미리만든 객체
				Enumeration<String> initParamEnum = application.getInitParameterNames();
				while (initParamEnum.hasMoreElements()) {
					String initParamName = initParamEnum.nextElement();
			%>
			<li>
				<%= initParamName %> = <%= application.getInitParameter(initParamName) %>
			<%
				}
			%>	
		</ul>
	</body>
</html>