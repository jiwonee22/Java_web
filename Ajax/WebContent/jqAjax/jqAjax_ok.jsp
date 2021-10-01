<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
<c:when test="${param.op eq 'add' }">
	${param.n1 } + ${param.n2 } = ${param.n1 + param.n2 }
</c:when> 
<c:when test="${param.op eq 'sub' }">
	${param.n1 } - ${param.n2 } = ${param.n1 - param.n2 }
</c:when> 
<c:when test="${param.op eq 'mul' }">
	${param.n1 } * ${param.n2 } = ${param.n1 * param.n2 }
</c:when> 
<c:when test="${param.op eq 'div' }">
	${param.n1 } / ${param.n2 } = ${param.n1 / param.n2 }
</c:when> 

</c:choose>