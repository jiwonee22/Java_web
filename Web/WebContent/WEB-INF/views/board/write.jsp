<%@page import="web.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {

	$("#btnWrite").click(function() {
		$(location).attr("href", "/board/write");
	});
	
});
</script>

<div>

<h1>글쓰기 페이지</h1>

<form action="<%=request.getContextPath() %>/member/write" method="post">

<label>
<input type="text" id="userid" name="userid" /></label><br>
<label>PASS
<input type="password" id="userpw" name="userpw" /></label><br><br>
<label>NICK
<input type="text" id="usernick" name="usernick" /></label><br><br>

<button>글 작성</button>

</form>



</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />