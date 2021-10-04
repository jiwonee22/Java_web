<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인 폼</h1>

<form action="<%=request.getContextPath() %>/member/login" method="post">

<label>ID
<input type="text" id="userid" name="userid" /></label><br>
<label>PASS
<input type="password" id="userpw" name="userpw" /></label><br><br>

<button>로그인</button>

</form>

</body>
</html>