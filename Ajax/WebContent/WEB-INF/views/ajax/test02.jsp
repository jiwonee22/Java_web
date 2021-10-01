<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/httpRequest.js"></script>

<script type="text/javascript">
window.onload = function() {
	btnAction.onclick = function() {
		console.log("btnAction clicked")
		
		sendRequest("POST", "/ajax/test02", "", callback);
	}
}

function callback() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			console.log("정상적인 AJAX 요청/응답 성공")
			
			printData();
		} else {
			console.log("AJAX 요청/응답 실패")
		}
	}	
	
}

function printData() {
	console.log("printData called")
	
	//AJAX응답으로 받은 HTML코드를 #result에 반영하기
	result.innerHTML = httpRequest.responseText
}

</script>

</head>
<body>

<h1>AJAX 테스트</h1>
<hr>

<button id="btnAction">AJAX 요청</button>

<div id="result"></div>

</body>
</html>