<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>파일 업로드</h1>
<h3>Commons Fileupload</h3>
<hr>

<!-- <form action="/commons/fileupload" method="get" -->
<!--  enctype="application/x-www-form-urlencoded"> -->

<!-- enctype: 데이터를 어떻게 포장해서 전송할건지 -->
<!-- "application/x-www-form-urlencoded" : 파일 이름만 전송(기본값) -->

<form action="/commons/fileupload" method="post"
 enctype="multipart/form-data">
 
<!-- "multipart/form-data" : 파일의 내용물까지 전달가능 -->
<!-- method도 post로 바꿔줘야함 -->

<label>제목 : <input type="text" name="title" /></label><br>
<label>데이터1 : <input type="text" name="data1" /></label><br>
<label>데이터2 : <input type="text" name="data2" /></label><br><br>

<label>파일 : <input type="file" name="upfile" /></label><br><br>

<button>전송</button>

</form>

</body>
</html>
