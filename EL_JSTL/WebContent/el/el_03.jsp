<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>EL의 컨텍스트 정보 객체</h1>
<hr>

<%	int localData = 100;

	pageContext.setAttribute("pageData", 200);
	request.setAttribute("requestData", 300);
	session.setAttribute("sessionData", 400);
	application.setAttribute("applicationData", 500);
%>

<%-- Java Scope에 만들어진 변수는 EL로 참조할 수 없다 --%>
localData: {$localData }

<hr>
page: ${pageScope.pageData }<br>
request: ${requestScope.requestData }<br>
session: ${sessionScope.sessionData }<br>
application: ${applicationScope.applicationData }<br>

<hr>
page: ${pageData }<br>
request: ${requestData }<br>
session: ${sessionData }<br>
application: ${applicationData }<br>

<%-- 컨텍스트 영역 내장객체는 생략 가능 --%>
<%--	page -> request -> session -> application 순으로 찾음 --%>
<%-- 	application까지 확인한 후 없는 변수라면 null 반환 --%>

</body>
</html>