<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head><title>application 기본 객체 속성 보기</title></head>
	<body>
		<%
			Enumeration<String> attrEnum = /* application.getAttributeNames(); */
					session.getAttributeNames();
			while(attrEnum.hasMoreElements()) {
				String name = attrEnum.nextElement();
				Object value = /* application.getAttribute(name); */
						session.getAttribute(name);
		%>
				application 속성: <b><%= name %></b> = <%= value %><br>
		<%
			}
		%>
	</body>
</html>