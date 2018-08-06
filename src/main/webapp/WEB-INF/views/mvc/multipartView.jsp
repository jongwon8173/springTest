<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>multipartView.jsp</title>
</head>
<body>
	multipartView.jsp
	
	<form action="/mvc/multipart/upload" enctype="multipart/form-data" method="post">
		<input type="text" name="userId" value="brown"/><br>
		<input type="file" name="uploadFile" /><br><br>


		<input type="file" name="files" /><br>
		<input type="file" name="files" /><br>
		
		
		<input type="submit" value="전송"/><br>
	</form>

</body>
</html>