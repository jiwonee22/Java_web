<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="subpage2">
<h3>추가된 페이지 영역</h3>
	
	
<%-- 전달파라미터 얻어오기 --%>	
<% String data = request.getParameter("data"); %>
	
<%	if(data != null && !"".equals(data)) { %>
<p>전달 파라미터 : <%=data %></p>
<%	} else {%>
<p>전달값이 없습니다</p>
<%	} %>
	
</div>
    