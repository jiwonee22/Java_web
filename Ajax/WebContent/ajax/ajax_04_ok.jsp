<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<div>
	name: ${param.username }<br>
	content: ${param.content }<br><br>
	${param.username}님, ${param.content}!<br><br>
</div>
<hr>