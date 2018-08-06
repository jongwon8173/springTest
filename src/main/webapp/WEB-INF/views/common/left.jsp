<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <!-- main.jsp 에서 top, left가 계속 고정되기 때문에 고정되는 부분 잘라내어 따로 뺌  -->
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="#">사용자</a></li>
		
		<li><a href="/student/list?page=1&pageSize=10">학생</a></li>
		
		<li><a href="/lprod/lprodList?page=1&pageSize=2">lprod</a></li>

		<!-- main.jsp에서 학생을 클릭했을 때 a href="/studentList" 어노테이션을 준 kr.or.ddit.student.web 아래 StudectServlet.java 로 이동한다.    -->
		
	</ul>
</div>