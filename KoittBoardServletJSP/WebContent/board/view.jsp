<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	<!-- JSTL 사용 -->
<!DOCTYPE html>
<html>
<head><title>글 상세보기</title></head>
<body>
	<table>
		<tbody>
			<tr>
				<th>번호</th>
				<td>${ requestScope.board.no }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${ requestScope.board.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${ requestScope.board.content }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${ requestScope.board.writer }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${ requestScope.board.regdate }</td>
			</tr>
		</tbody>
	</table>
	
	<a href="<c:url value='/board/delete-confirm.jsp?no=${ requestScope.board.no }' />">
		삭제하기
	</a>
	<a href="<c:url value='/BoardServlet?cmd=CMD_UPDATE_FORM&no=${ requestScope.board.no }'/>">
		수정하기
	</a>
</body>
</html>







