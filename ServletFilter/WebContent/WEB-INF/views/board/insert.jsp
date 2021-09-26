<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>게시글 등록</h1>
<hr>

<form action="<%=request.getContextPath() %>/board/insert" method="post">

<label>제목 <input type="text" name="title" /> </label><br>
<label>내용 <input type="text" name="content" /> </label><br>

<button>작성</button>

</form>
</html>