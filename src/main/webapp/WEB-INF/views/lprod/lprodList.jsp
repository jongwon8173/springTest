<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  <!-- JSTL 사용하려면 추가   -->


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

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">

<script>
	$(function(){
		$("table tbody tr").on("click", function(){
			// tr태그의 data-id 속성 값을 읽어서 input태그의 id값으로 설정 
			// form 태그를 submit
// 			console.log("table tbody tr clicked : " + $(this).data("id") );  /* 클릭했을 떄 학생의 아이디를 얻어오기 작업   */
			$("#lprod_id").val($(this).data("lprod_id"));
			$("#frm").submit();   			 
		});
	});
</script>



</head>

<body>
	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<form id="frm" action="/lprod/lprodDetail" method="get">  <!-- ★ 경로수정  -->
		<input type="hidden" name="lprod_id" id="lprod_id">
	</form>
	
	<div class="container-fluid">
		<div class="row">
		
		<!-- left.jsp 부분 잘라내어 따로 뺌  -->
		<%@include file="/WEB-INF/views/common/left.jsp" %>
		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">제품대분류</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr> 
										<th>상품 순번</th>
										<th>상품대분류 코드</th>
										<th>상품대분류 이름</th>
									</tr>
								</thead>
								
								<tbody>		
									<!-- EL방식으로  -->
									<c:forEach items="${lprodList}" var="vo">
										<tr data-lprod_id="${vo.lprod_id }">
											<td>${vo.lprod_id}</td>
											<td>${vo.lprod_gu}</td>
											<td>${vo.lprod_nm}</td>
										</tr>
									</c:forEach>
								</tbody> 
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
									<!--페이징 처리  -->
									<%=request.getAttribute("pageNavi") %>
									

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>