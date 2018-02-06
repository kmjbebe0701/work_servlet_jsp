<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>도서 상세 보기</title></head>
<body>
	<h2>도서 상세 보기</h2>
	<a href="<c:url value='/BookServlet?cmd=CMD_LIST' />">도서 목록</a>
	<table>
		<thead>
			<tr>
				<th> 책 번호 </th>
				<th> 책 제목 </th>
				<th> 저자 </th>
				<th> 출판사 </th>
				<th> 가격 </th>
				<th> 책 소개 </th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${ requestScope.book.isbn }</td>
					<td>${ requestScope.book.title }</td>
					<td>${ requestScope.book.author }</td>
					<td>${ requestScope.book.publisher }</td>
					<td>${ requestScope.book.price }</td>
					<td>${ requestScope.book.description }</td>
				</tr>
		</tbody>
	</table>
	
	<a href="<c:url value='/book/delete-confirm.jsp?isbn=${ requestScope.book.isbn }'/> "> 삭제하기 </a>
	<a href="<c:url value='/BookServlet?cmd=CMD_UPDATE_FROM&isbn=${ requestScope.book.isbn } '/> "> 수정하기 </a>
	

</body>
</html>