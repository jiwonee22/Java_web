<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 예외발생 시 이동할 페이지 URL 지정하기 --%>
<%@ page errorPage="/basicTag/errorpage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>에러페이지 테스트</h1>
<hr>

<%-- ArithmeticException(/ by zero) 발생시키기 --%>

<%
	int num = 7/0;
%>

</body>
</html>