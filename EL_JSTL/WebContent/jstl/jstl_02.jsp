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

<h1>c:out</h1>
<hr>

<c:out value="Hello JSTL" />
<hr>

elData: <c:out value="${elData }" /><br>
empty elData: <c:out value="${empty elData }" />
<hr>

<c:out value="${elData }" default="elData가 null값" />
<hr>

<%-- 잘못 설정한 경우 --%>
<%-- 	value를 빈칸으로 작성해도 null 취급하지 않는다 --%>
<%--	value에 "null"을 작성한 건 문자열 "null"이 된다 --%>
빈문자열: <c:out value="" default="빈 문자열 출력" /><br>
"null": <c:out value="null" default="null 출력" />

El null: <c:out value="${null }" default="EL nll값 출력"/><br>
Expression null: <c:out value="<%=null %>" default="Expression null값 출력" />
 
<hr>

<c:out value="<h3>태그 출력</h3>" />
<c:out value="<h3>태그 출력</h3>" escapeXml="false" />

<hr>
<%="<h3>태그 출력</h3>" %>
<%="&lt;h3&gt;태그 출력&lt;h3&gt;" %>

<hr>

띄어쓰기: &nbsp;<br>

왼쪽 2중 꺽쇠: &laquo;<br>
오른쪽 2중 꺽쇠: &raquo;<br>

왼쪽 화살표: &larr;<br>
오른쪽 화살표: &rarr;<br>

copyright &copy;
 



</body>
</html>