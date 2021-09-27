<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>쿠키 확인</h1>
<hr>

<table border="1">
<% for(Cookie c : request.getCookies()) { %>
<tr>
	<td><%=c.getName() %></td>
	<td><%=c.getValue() %></td>
</tr>
<% } %>
</table>

<hr>

<%-- ${cookie } --%>

<table border="1">
<c:forEach items="${cookie }" var="c"> <!-- ${cookie }는 내장객체 -->
<tr>
	<td>${c.value.name }</td>
	<td>${c.value.value }</td>
</tr>
</c:forEach>
</table>

<hr>

${cookie.ID.value }<br> <!-- cookie.get("ID").getValue(); -->
${cookie.PASS.value }<br> 
${cookie.NAME.value }<br>

<hr>

<h3><a href="<%=request.getContextPath() %>/cookie/create">쿠키 생성</a></h3>
<h3><a href="<%=request.getContextPath() %>/cookie/update">쿠키 수정</a></h3>
<h3><a href="<%=request.getContextPath() %>/cookie/delete">쿠키 삭제</a></h3>

</body>
</html>