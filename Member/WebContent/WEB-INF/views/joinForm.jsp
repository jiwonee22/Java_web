<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 폼 띄우기</h1>

<form action="/member/join" method="post">

<label for="userid">아이디</label>
<input type="text" name="userid" id="userid" /> <br>

<label for="nick">닉네임</label>
<input type="text" name="nick" id="nick" /> <br>

<label for="email">이메일</label>
<input type="text" name="email" id="email" /> <br>

<br>
<input type="submit" value="회원가입" />

</form>

</body>
</html>