<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />


<div class="container">

<h1>게시글 목록</h1>

<table class="table table-striped table-hover table-condensed">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>조회수</th>
	<th>작성날짜</th>
</tr>

<c:forEach items="${boardList }" var="board">
<tr>
	<td>${board.boardno }</td>
	<td><a href="/board/view?boardno=${board.boardno }">${board.title }</a></td>
	<td>${board.userid}</td>
	<td>${board.hit}</td>
	<td>${board.writeDate}</td>
</tr>
</c:forEach>


</table>

<c:if test ="${empty login }">

<button onclick="location.href = '/main';">글쓰기</button>

</c:if>

<c:if test ="${not empty login }">

<button onclick="location.href = '/board/write';">글쓰기</button>

</c:if>



</div>
<c:import url="/WEB-INF/views/layout/paging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />
