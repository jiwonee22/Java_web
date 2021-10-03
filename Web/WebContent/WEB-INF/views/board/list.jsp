<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

table, th, td {
	border : 1px solid black;
	border-collapse: collapse;
}

</style>

</head>
<body>

<h1>글 목록 전부 보여주기</h1>

<table>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>게시글 내용</th>
	<th>조회수</th>
	<th>작성날짜</th>
</tr>


<c:forEach var="board" items="${list }">
<tr>
	<td>${board.boardNo }</td>
	<td>${board.title }</td>
	<td>${board.userId}</td>
	<td>${board.content}</td>
	<td>${board.hit}</td>
	<td>${board.writeDate}</td>
</tr>
</c:forEach>


</table>


</body>
</html>