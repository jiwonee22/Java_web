<%@page import="dto.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Emp result = (Emp) request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Emp 상세보기</h1>
<hr>

<table>
<thead>
<tr>
	<th style="width: 10%">사번</th>
	<th style="width: 20%">사원이름</th>
	<th style="width: 15%">직무</th>
	<th style="width: 10%">담당자</th>
	<th style="width: 15%">입사날짜</th>
	<th style="width: 10%">급여</th>
	<th style="width: 10%">상여금</th>
	<th style="width: 10%">부서</th>
</tr>
</thead>

<tr>
	<td><%=result.getEmpno() %></td>
	<td><%=result.getEname() %></td>
	<td><%=result.getJob() %></td>
	<td><%=result.getMgr() %></td>
	<td><%=result.getHiredate() %></td>
	<td><%=result.getSal() %></td>
	<td><%=result.getComm() %></td>
	<td><%=result.getDeptno() %></td>
</tr>
</table>

<br>
<a href="/emp/list"><button>목록</button></a>

</body>
</html>