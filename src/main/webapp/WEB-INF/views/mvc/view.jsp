<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/mvc/view.jsp </title>
</head>
<body>
	<!-- 07.31 -->
	<h3>Spring</h3>
	/mvc/view.jsp 호출  : boardNum : ${boardNum}
	
	<hr>
	
	<form action="/mvc/requestParam" method="post">
		<input type="text" name="userId" value="brown" > <br>
		<input type="submit" value="전송" > <br>
		
	</form>
	
	<!-- 08.01 -->
	<c:forEach items="${boardList}" var="board">
		${board }<br>
	</c:forEach>
	
</body>
</html>