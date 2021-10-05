<%@page import="web.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/board/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
	});
	
});
</script>

<div class="container">

<h1> 게시글 상세 보기</h1>
<hr>

<table class="table table-bordered">
<tr>
	<td>번호 : ${viewBoard.boardno }</td>
</tr>
<tr>
	<td>제목 : ${viewBoard.title }</td>
</tr>
<tr>
	<td>작성자 : ${viewBoard.userid }</td>
</tr>
<tr>	
	<td>조회수 : ${viewBoard.hit }</td>
</tr>
<tr>	
	<td>작성날짜 : ${viewBoard.writeDate }</td>	
</tr>

<tr>
	<td>내용</td>
</tr>
<tr>
	<td>${viewBoard.content }</td>
</tr>

</table>

<div class="text-center">	
	<button id="btnList" class="btn btn-primary">목록</button>
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
</div>

</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />