<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>fmt:formatNumber</h1>
<hr>

<fmt:formatNumber value="1234567890" /><br>
<fmt:formatNumber value="1234567890" type="number" /><br>
<fmt:formatNumber value="1234567890" type="currency" /><br>
<fmt:formatNumber value="1234567890" type="percent" /><br>

<%--groupingUsed: 자릿수 구분자 사용 여부 (기본값 true) --%>
<fmt:formatNumber value="1234567890" type="number" groupingUsed="false" /><br>
<hr>

<fmt:formatNumber value="1234567890" type="currency" currencySymbol="$" /><br>
<fmt:formatNumber value="1234567890" type="currency" currencySymbol="T" /><br>
<hr>

<%-- minIntegerDigits: 정수부분 최소 자릿수 개수 --%>
<%-- minFractionDigits: 소수부분 최소 자릿수 개수 --%>
<fmt:formatNumber value="1234" type="currency" currencySymbol="$"
	minIntegerDigits="5" minFractionDigits="2" /><br>

<%-- minFractionDigits속성을 설정하지 않으면 소수점이하 반올림한다 --%>
<fmt:formatNumber value="12345.6" type="currency" />
<hr>

<fmt:formatNumber value="12345.60" type="currency" currencyCode="KRW" /><br>
<fmt:formatNumber value="12345.60" type="currency" currencyCode="USD" /><br>
<fmt:formatNumber value="12345.60" type="currency" currencyCode="JPY" />
<hr>

<fmt:formatNumber value="12345.67890" pattern="##,###.###" /><br>
<fmt:formatNumber value="1234512345.67" pattern="##,###.###" /><br>
<fmt:formatNumber value="45.67" pattern="##,###.###" /><br>

<fmt:formatNumber value="12345.67890" pattern="00000000.00000000" /><br>



</body>
</html>