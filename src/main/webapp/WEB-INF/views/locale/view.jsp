<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src=/js/jquery-1.12.4.js ></script>

 <script type="text/javascript">
 	$(document).ready(function(){
 		$("select[name=language]").on("change", function(){
 			
 			
 			
 		})
 	});
 
 </script>

</head>
<body>
	view.jsp  //
	로그인 페이지를 만든다 가정하고 국제화 이용하기  <hr>

	
	<spring:message code="userId" /> : <input type="text" name="userId"><br>
	<spring:message code="password" /> : <input type="text" name="password"><br>

	<h3>localeChange</h3>
	
	<form action="/locale/view">	<!-- 호출한 본인에게 다시 돌아가게 임의로 설정  -->
		<select name="language">
			<c:forEach items="${localeMap}" var="locale">
				<option value="${locale.key }" 	<c:if test="${param.language==locale.key}">selected</c:if>   
				 >	${locale.value }</option> 
			</c:forEach>
		</select> <br> 
<!-- 		<input type="submit" value="전송"> -->
	</form>

</body>
</html>

<!-- 

	1. jquery를 활용하여 select box 변경시 submit이 되도록 수정 
	2. select box가 현재 locale로 selected 되도록 수정 


 -->