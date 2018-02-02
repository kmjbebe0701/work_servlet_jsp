<!-- p.300 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<!-- JSTL(JSP Standard Tag Library) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>if 태그</title></head>
<body>
	<!-- JSTL core 사용 -->
	<c:if test="true">
		무조건 수행<br>
	</c:if>
				<!-- EL 사용 -->
	<c:if test="${ param.name == 'bk' }">
		name 파라미터의 값이 ${ param.name } 입니다.<br>
	</c:if>
	
	<c:if test="${ 18 < param.age }">
		당신의 나이는 18세 이상입니다.
	</c:if>
</body>
</html>