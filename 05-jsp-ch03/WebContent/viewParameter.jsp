<!-- p.77 -->
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	//클라이언트 오청을 utf-8인코딩 방식으로 읽는다.
	request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE html>
<html>
<head>
<title>요청 파라미터 출력</title>
</head>
<body>
	<b>request.getParameter()메서드 사용</b><br> 
	name파라미터 =<%=request.getParameter("name")%><br>
	address파라미터 =	<%=request.getParameter("address")%>
	<p>
	<b>request.get.ParameterValues()메서드 사용</b><br>
		<%
			String[] values = request.getParameterValues("pet");
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
		%>
					<%= values[i]%>
		<%
				}
			}
		%>
	
	<p>
	<b>request.get.ParameterNames()메서드 사용</b><br>
		<%
			Enumeration paramEnum = request.getParameterNames();
		
			//hasMoreElements는 다음 꺼낼 것이 있는지 물어본다
			while (paramEnum.hasMoreElements()) {
				//nextElement 다음 배열값을 가져온다
				String name = (String) paramEnum.nextElement();
		%>
					<!-- 표현식을 이용하여 출력 -->
					<%=name%>
		<%
			}		//while문을 닫는 중괄호
		%>
	
	<p>
		<b>request.get.ParameterMap()메서드 사용</b><br>
		<%
			//getParameterMap()은 전달받은 파라미터들을 map형태로 제공
			Map parameterMap = request.getParameterMap();
		
			//name을 key로 가지는 값을 배열을 리턴받는다.
			String[] nameParam = (String[]) parameterMap.get("name");
			if (nameParam != null) {
		%>
				name = <%=nameParam[0]%>
		<%
			}
		%>
	
</body>
</html>