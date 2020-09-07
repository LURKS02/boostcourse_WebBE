<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- jsp comment
	여러 줄로 사용 가능	
	--%>
	
<!--  html comment -->
<%
//java comment
/*
여러 줄로 사용 가능
*/

	//스크립트릿
	for(int i = 1; i <= 5; i++){
		
%>
<H<%=i %>>아름다운 한글</H<%=i %>>
<%
	}
%>
</body>
</html>