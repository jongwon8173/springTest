<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  <!-- JSTL 사용하려면 추가   -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- JSTL 포멧라이브러리 사용하려면 추가 07.13  -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>



<script><!--07.17 추가  -->
	$(function(){
		$("table tbody tr").on("click", function(){
			// tr태그의 data-id 속성 값을 읽어서 input태그의 id값으로 설정 
			// form 태그를 submit
// 			console.log("table tbody tr clicked : " + $(this).data("id") ); /* 클릭했을 떄 학생의 아이디를 얻어오기 작업   */
			$("#id").val($(this).data("id"));
			$("#frm").submit();   			 /*<!--07.17 추가 StudentDetailServlet 으로 이동 <form id="frm" action="/studentDetail" -->  */
		});
	});

</script>


	
	<!--07.17 추가 StudentDetailServlet 으로 이동 -->
	<form id="frm" action="/student/tiles/detail" method="get">  <!-- ★ 경로수정  -->
		<input type="hidden" name="id" id="id">
	</form>
	
	
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
							
						
						
								
								<tbody>
<!-- 								// 학생 페이지 리스트 조회 / StudentService에서  getStudentPageList( Map<String, Integer> map ) 메소드를 통해 가져옴 
									List<StudentVo> studentList = studentDao.getStudentPageList(map);
									resultMap.put("studentList", studentList); -->
									
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
									<%=request.getAttribute("pageNavi") %>
<!-- 								<li><a href="#">1</a></li> -->
<!-- 								<li><a href="#">2</a></li> -->
<!-- 								<li><a href="#">3</a></li> -->
<!-- 								<li><a href="#">4</a></li> -->
<!-- 								<li><a href="#">5</a></li> -->
									
							</ul>
						</div>
					</div>
				</div>
