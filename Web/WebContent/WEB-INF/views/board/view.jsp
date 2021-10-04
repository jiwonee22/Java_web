<%@page import="web.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="/WEB-INF/views/layout/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 게시글 상세 보기</h1>

<table class="table table-striped table-hover table-condensed">
<tr>
	<td>번호 : ${viewBoard.boardno }</td>
	<td>제목 : ${viewBoard.title }</td>
	<td>작성자 : ${viewBoard.userid }</</td>
	<td>조회수 : ${viewBoard.hit }</</td>
	<td>작성날짜 : ${viewBoard.writeDate }</</td>
</tr>

<tr>
	<td>내용</td>
	<td>${viewBoard.content }</td>
</tr>

</table>

<c:import url="/WEB-INF/views/layout/footer.jsp" />