<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>

<form action="/member/join" method="post">

<label>ID
<input type="text" id="userid" name="userid" /></label><br>
<label>PASS
<input type="password" id="userpw" name="userpw" /></label><br><br>
<label>NICK
<input type="text" id="usernick" name="usernick" /></label><br><br>

<button>회원가입</button>

</form>

</body>
</html>