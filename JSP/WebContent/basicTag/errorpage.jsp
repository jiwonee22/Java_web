<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="color: red;">에러 처리 페이지</h1>
<hr>

<h3>에러 내용</h3>

<%-- JSP페이지가 isErrorPage로 설정되어야 사용 가능 --%>
<%=exception %>

</body>
</html>