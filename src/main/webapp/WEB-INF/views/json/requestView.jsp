<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>localhost:8180/json/requestView </title>

<script src="/js/jquery-1.12.4.js"></script>
<script type="text/javascript">

	$(function() {
		console.log("requestView.jsp ready");

		var rangers = [ "brown", "cony", "sally" ];  // var rangers = new Array();   // rangers.push("brown");

		$("#btn").on("click", function() {   // 버튼을 클릭했을시에만 되도록 

			$.ajax({
				url : "/json/requestBody",
				method : "post",
				contentType : "application/json; charset=utf-8", 	// json 전송을 알려주는 contentType
				dataType : "json", 									// server로 부터 받을 data typq
				data : JSON.stringify(rangers), 					// 전송할 json 문자열 
				
				success : function(data) {
					console.log(data);  				// 정상진행되는지 체크하면서 진행.. 개발자 로그에  ["brown_requestBody", "cony_requestBody", "sally_requestBody"] 출력되는것 확인
					$("#screen").html(data);
				}
			});
		});
	});
</script>

</head>

<body>

<h3>requestView.jsp</h3>
	<button id="btn">전송</button><br>
	<div id="screen">  
	
	</div>
	

</body>
</html>