<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>EL의 자료형</h1>
<hr>

정수형: ${123 } <br>
실수형: ${123.456 } <br>
단일문자: ${'A' } <br>
문자열: ${"Apple" } <br>
논리형: ${true } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${false }<br>
null: ${null }<br>

<%-- null키워드는 출력했을 때 아무런 값도 출력되지 않는다 --%>
<br>

<h1>EL 연산자</h1>

${13 / 6 }<br> <%-- int형/int형이지만 정수로 출력되지 않음 --%>

<%-- ${13 div 6 }<br> 에러 아님, 이클립스 버그, 결과는 정상적으로 출력된다 --%>
${13 mod 6 }<br>


${123 == 123 }<br>
${123 eq 123 }<br>


str: ${str }<br> <%-- null --%>
empty str: ${empty str } <%-- str변수가 null인지 체크 --%>

<hr>

<%-- EL에서는 변수에 값을 대입하는 코드 사용하지 말것! --%>
${str = "Banana" }<br>
str: ${str }<br>

<hr>

<h3>자바영역의 변수를 EL에서 사용하기</h3>
<% int num = 333; //Java영역에 선언된 변수
%>
num: ${num }<br>
empty num: ${empty num }<br>

<%-- EL구문에서는 Java영역의 변수를 인식할 수 없다 --%>

<hr>

<h3>컨텍스트 영역의 변수를 EL에서 사용하기</h3>
<% pageContext.setAttribute("data", 555); //page 스코프
%>
data: ${data }<br>
empty data: ${empty data }<br>


</body>
</html>