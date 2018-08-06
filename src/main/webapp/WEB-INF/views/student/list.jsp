<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  <!-- JSTL 사용하려면 추가   -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- JSTL 포멧라이브러리 사용하려면 추가 07.13  -->


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

<title>Spring "/student/list.jsp"</title>

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
		$("#studentList").on("click", "tr", function(){
// 		$("table tbody tr").on("click", function(){
			// tr태그의 data-id 속성 값을 읽어서 input태그의 id값으로 설정 
			// form 태그를 submit
// 			console.log("table tbody tr clicked : " + $(this).data("id") ); /* 클릭했을 떄 학생의 아이디를 얻어오기 작업   */
			$("#id").val($(this).data("id"));
			$("#frm").submit();   			 /*<!--07.17 추가 StudentDetailServlet 으로 이동 <form id="frm" action="/studentDetail" -->  */
		});
		
		
		//수기로 작성한 페이지 링트 틀릭시 이벤트 핸들러 	
		$("#pageLink li").on("click",function(){
			console.log("page :" + $(this).text());
			var page =  $(this).text();

			 	$.ajax({
				url : "/student/list/json",
				method : "post",
				//contentType : "application/json; charset=utf-8", // json 전송을 알려주는 contentType
				dataType : "json", // server로 부터 받을 data typq
				//data : JSON.stringify(rangers), // 전송할 json 문자열 
				data : "page=" + page + "&pageSize=10",   // 페이지 값을 무조건 1로 세팅해놈 
				
				success : function(data) {
					// 1. 화면에 있는 학생리스트를 삭제한다. 
					$("#studentList").html("");
					
					// 2. data.studentList에 있는 학생 리스트  데이터를 이용하여  html로 생성한다. 
					/* 	<tr data-id="${vo.id }" >  <!--값을 가져오는방법 data-name="${vo.name }" 07.17-->                                                                          				
							<td>${vo.id }</td>                                                         				
							<td>${vo.name}</td>                                                        				
							<td>${vo.call_cnt}</td>                                                    				
							<td><fmt:formatDate value="${vo.reg_dt}" pattern="yyyy-MM-dd"/> </td>      				
						</tr>      */ 
					var html = "";
						$.each(data.studentList, function(idx, student){
							html = html + "<tr data-id='" + student.id + "' >";
							html = html + "<td>" + student.id + "</td>";
							html = html + "<td>" + student.name + "</td>";
							html = html + "<td>" + student.call_cnt + "</td>";
							html = html + "<td>" + student.reg_dt + "</td>";
							html = html + "</tr>";
							
						});
					// 3. 학생리스트 위치에 html을 붙여준다 $.html("2번에서 만든 html");
						$("#studentList").html(html);
				}
			}); // $.ajax 
			
		});
			
			
		
	});

</script>


</head>

<body>
<!-- url : localhost:8180/main.jsp 으로 시작해야함  -->

	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/WEB-INF/views/common/top.jsp" %>  <!-- ★ 경로수정  -->
	
	<!--07.17 추가 StudentDetailServlet 으로 이동 -->
	<form id="frm" action="/student/detail" method="get">  <!-- ★ 경로수정  -->
		<input type="hidden" name="id" id="id">
	</form>
	
	
	<div class="container-fluid">
		<div class="row">
		
		<!-- left.jsp 부분 잘라내어 따로 뺌  -->
		<%@include file="/WEB-INF/views/common/left.jsp" %> <!-- ★ 경로수정  -->
		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">학생</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr> 
										<th>학생 ID</th>
										<th>학생 이름</th>
										<th>지명 횟수</th>
										<th>등록일자(yyyy-mm-dd)</th> <!--07.13 학생테이블의 등록일자 컬럼을 추가(update)하고 화면에 date타입을 해당패턴으로 출력하기   -->
									</tr>
								</thead>	
							
						
						
								
								<tbody id="studentList">
	
								<!-- EL방식으로  -->                                                                   				
									<c:forEach items="${studentList}" var="vo">        
										<!-- tr 태그 클릭시 상세페이지로 이동 07.17 추가   -->                                    				
										<tr data-id="${vo.id }" >  <!--값을 가져오는방법 data-name="${vo.name }" 07.17-->                                                                          				
											<td>${vo.id }</td>                                                         				
											<td>${vo.name}</td>                                                        				
											<td>${vo.call_cnt}</td>                                                    				
											<td><fmt:formatDate value="${vo.reg_dt}" pattern="yyyy-MM-dd"/> </td>      				
										</tr>                                                                          				
									</c:forEach>                                                                       				
								</tbody>                                                                               				
							</table>                                                                                   				
						</div>                                                                                         				

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
<%-- 									<%=request.getAttribute("pageNavi") %> --%>

									
							</ul>
							
							<ul id="pageLink" class="pagination">
								<li>1</li>&nbsp;&nbsp;
								<li>2</li>&nbsp;
								<li>3</li>
									
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>