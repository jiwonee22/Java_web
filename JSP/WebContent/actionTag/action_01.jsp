<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>액션태그 테스트</h1>
<hr>

<%-- 액션태그를 이용한 JavaBean 생성 --%>
<jsp:useBean id="user1" class="dto.User"></jsp:useBean>

<%-- 스크립트릿을 이용한 자바 객체 생성 --%>
<%	User user2 = new User(); %>

<%-- 자바영역의 객체 출력하기 --%>
user1: <%=user1 %><br>
user2: <%=user2 %>

<%-------------------------------------------------------- --%>
<hr>

<%-- 스크립트릿을 이용하여 멤버필드 값 저장하기 --%>
<%	user1.setUserid("id1");
	user1.setUserpw("pw1");

	user2.setUserid("id2");
	user2.setUserpw("pw2");
%>

<%-- 자바영역의 객체 출력하기 --%>
user1: <%=user1 %><br>
user2: <%=user2 %>

<%-------------------------------------------------------- --%>
<hr>

<%-- 컨텍스트 영역(Page Scope)에 JavaBean 객체가 생성된다 --%>
<jsp:useBean id="user3" class="dto.User" />

<%-- 자바 영역(지역 변수)에 자바 객체가 생성된다 --%>
<% User user4 = new User(); %>

<jsp:setProperty property="userid" name="user3" value="id3" />
<jsp:setProperty property="userpw" name="user3" value="pw3" />

user3: <%=user3 %><br>

<%-- 에러 발생! --%>
<%-- 	user4가 컨텍스트 영역에 존재하지 않아 null처리됨 --%>
<%-- <jsp:setProperty property="userid" name="user4" value="id4" /> --%>
<%-- <jsp:setProperty property="userpw" name="user4" value="pw4" /> --%>

<%-- 해결법 --%>
<%--	자바영역의 객체를 컨텍스트영역에 등록한다 --%>
<%	
	pageContext.setAttribute("user4", user4); //page영역에 등록
// 	request.setAttribute("user4", user4); //request영역에 등록
// 	session.setAttribute("user4", user4); //session영역에 등록
// 	application.setAttribute("user4", user4); //application영역에 등록
%>

<jsp:setProperty property="userid" name="user4" value="id4" />
<jsp:setProperty property="userpw" name="user4" value="pw4" />

user4: <%=user4 %>




</body>
</html>

















