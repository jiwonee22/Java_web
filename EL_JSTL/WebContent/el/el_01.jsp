<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>EL 테스트 01</h1>
<hr>

${"<h3>표현 언어, EL<h3>" }
<h3>${"표현 언어, EL"}</h3>
<!-- 둘 다 똑같이 표현되지만 HTML태그를 밖에 두는게 더 좋다 -->

<hr>

<%="<h3>표현식 태그, Expression</h3>" %>
<h3><%="표현식 태그, Expression" %></h3>

<hr>

<% out.print("<h3>스크립트릿, Scriptlet</h3>"); %>
<h3><% out.print("스크립트릿, Scriptlet"); %></h3>


</body>
</html>