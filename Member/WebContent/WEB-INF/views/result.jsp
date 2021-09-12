<%@page import="dto.Member"%>

<!-- 자동 import 단축키 ctrl + space -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% Member m = (Member) request.getAttribute("result"); %>
<!-- MeberController파일에서 setAttribute로 보낸 "result"객체 받음 -> Member타입으로 형변환 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입 처리하기</h1>
<hr>

번호 : <%=m.getUserno() %><br>
아이디 : <%=m.getUserid() %><br>
닉네임 : <%=m.getNick() %><br>
이메일 : <%=m.getEmail() %><br>

<a href="/member/join">회원가입 페이지로 돌아가기</a>

</body>
</html>