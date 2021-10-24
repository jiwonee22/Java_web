<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/resources/js/httpRequest.js"></script>

<script type="text/javascript">
//AJAX 요청 보내는 메소드
function send() {
	//----- 전달 파라미터 구성 -----
	var n = username.value;
	var c = content.value;
	
	var params = "name="+n+"&content="+c;
	
	//----- URL 구성 ----
	var url = "/ajax/ajax_04_ok.jsp";
	
	//----- AJAX 요청 전송 -----
	sendRequest("POST", url, params, callback);
}

//AJAX 응답 처리하는 콜백함수
function callback() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			console.log("AJAX 정상 응답")
			
			//정상응답 처리 함수
			appendResult();
			
		} else {
			console.log("AJAX 요청/응답 에러")
		}
	}
}

//정상 응답 후 응답데이터 처리하는 함수
function appendResult() {
	result.innerHTML += httpRequest.responseText;
}
</script>

</head>
<body>

<h1>AJAX 04</h1>
<hr>

<!-- 이름, <input>태그, id="username" -->
<!-- 내용, <input>태그, id="content" -->

<!-- 이름, 내용 두가지 데이터를 ajax_04_ok.jsp 로 전송 -->
<!-- 전송한 데이터를 이용하여 응답데이터로 작성한다 -->

<!-- 응답 받은 데이터를 이용하여 <div>를 생성하고 그 안에 데이터를 기록 -->
<!-- 형식

	<div>
		name: Alice
		content: 안녕하세요!
		
		Alice님, 안녕하세요!
	</div>

 -->

<!-- 응답받은 <div>데이터는 <button> 하단에 계속해서 추가되도록 만든다 -->

<div>
	<label>이름 <input type="text" id="username" /></label><br>
	<label>내용<br>
		<textarea id="content"></textarea>
	</label><br><br>
	
	<button onclick="send();">전송</button>
</div>

<div id="result"></div>


</body>
</html>
