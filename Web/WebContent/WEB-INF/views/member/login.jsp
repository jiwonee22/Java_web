<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="container">
<div class="text-center">

<form action="<%=request.getContextPath() %>/member/login" method="post">

<label>아이디
<input type="text" id="userid" name="userid" /></label><br>
<label>패스워드
<input type="password" id="userpw" name="userpw" /></label><br><br>

<button>로그인</button>

</form>

</div>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />

