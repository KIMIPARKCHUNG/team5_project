<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="/fileUpload" method="POST" enctype="multipart/form-data">
	        		<span style="font-size:12pt;">
	        			<!-- input 박스 -->
	        			<input type="file" name="file" size="30">
	        		</span>
	        	<span style="font-size:12pt;">
						<input type="submit" value="부서생성">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</span>
	      </form>
	      	<span style="font-size:12pt;">
	        			<a href="http://localhost:8000/download/file/12115">12115</a>
	        		</span>
</body>
</html>