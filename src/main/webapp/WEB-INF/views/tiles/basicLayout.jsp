<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>main.jsp를 이용한 basicLayout.jsp 레이아웃 만들기</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">
</head>

<body>
	<!--url:  http://localhost:8180/main.jsp -->


	<%-- 	<%@ include file="/WEB-INF/views/common/top.jsp"%> --%>
	<tiles:insertAttribute name="top" />


	<div class="container-fluid">
		<div class="row">

			<%-- 	<%@ include file="/WEB-INF/views/common/left.jsp"%> --%>
			<tiles:insertAttribute name="left" />
			

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<tiles:insertAttribute name="content" />

			</div>
			
		</div>
	</div>
</body>
</html>
