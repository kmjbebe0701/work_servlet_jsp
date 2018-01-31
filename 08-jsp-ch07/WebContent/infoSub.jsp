<!-- p.164 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String type = request.getParameter("type");
	if (type == null) {
		return;
	}
%>
<br>
<table width = "100%" border="1" cellpadding="0" cellspacing="0">
	<tr>			<!--  행  -->
		<td>타입</td>			<!-- 1열 -->
		<td><b><%= type %></b></td>			<!-- 2열 -->
	</tr>
	<tr>			<!-- 행 -->
		<td>특징</td>			<!-- 1열 -->
		<td>
			<%if (type.equals("A")){ %>
				강한 내구성
			<%}else if (type.equals("B")){ %>
				뛰어난 대처능력
			<%} %>
		</td>		<!-- 2열 -->
	</tr>
	</table>