<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- spring에서 제공하는 태그라이브러리 사용을 위해 작성 -->    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mvc/valid/view.jsp</title>
</head>
<body>

	mvc/valid/view.jsp   <br>
	: 에러가 발생하면 errorMsg 출력할 메세지:  ${errorMsg }
	<hr>
	
	<spring:hasBindErrors name="validVo"/>
	<spring:hasBindErrors name="validJsr303Vo"/>
	
	<h3>ValidVo validator(검증) </h3>
	
	<form action="/valid/submit" method="post">
		userId   : <input type="text" name="userId" value="brown">  	<form:errors path="validVo.userId"/> <br>
		name   	 : <input type="text" name="name" value="브라운"> 		<form:errors path="validVo.name"/> <br>
		password : <input type="password" name="password" value=""> 	<form:errors path="validVo.password"/> <br>
		<input type="submit" value="전송"> <br>
	</form>
	
	<hr ><!--========================================================================================================================-->
	
	<h3>Jsr 303 validator </h3>
	
	<form action="/valid/submit/jsr303" method="post">
		userId   : <input type="text" name="userId" value="brown">  	<form:errors path="validJsr303Vo.userId"/> <br>
		name   	 : <input type="text" name="name" value="브라운"> 		<form:errors path="validJsr303Vo.name"/> <br>
		password : <input type="password" name="password" value=""> 	<form:errors path="validJsr303Vo.password"/> <br>
		<input type="submit" value="전송"> <br>
	</form>
	
	<hr ><!--========================================================================================================================-->
	
	<h3>Spring validator + jsr303(@valid) </h3>
	
	<form action="/valid/submit/valid" method="post">
		userId   : <input type="text" name="userId" value="brown">  	<form:errors path="validVo.userId"/> <br>
		name   	 : <input type="text" name="name" value="브라운"> 		<form:errors path="validVo.name"/> <br>
		password : <input type="password" name="password" value=""> 	<form:errors path="validVo.password"/> <br>
		<input type="submit" value="전송"> <br>
	</form>
	
</body>
</html>