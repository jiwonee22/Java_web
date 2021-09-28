<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

//AJAX통신 객체인 XMLHttpRequest객체를 생성하는 함수(크로스브라우징)
function createXHR() {

	//XHR객체 변수
	var xmlReq = null;
	
	
	if(window.XMLHttpRequest) { //XMLHttpRequest내장 객체가 존재할 때
		//IE 7.0 이상
		//IE브라우저가 아닐 때(크롬, 사파리, 오페라 등등)
		
		//XHR객체 생성
		xmlReq = new XMLHttpRequest();
	
	} else if(window.ActiveXObject) { //ActiveXObject내장 객체가 존재할 때
		//IE 계열 브라우저
		
		try {
			//비교적 최근 IE브라우저의 XHR객체 생성
			xmlReq = new ActiveXObject("Msxml2.XMLHTTP");			
		} catch (e1) {
			
			try {
				//비교적 예전 버전 IE브라우저의 XHR객체 생성
				xmlReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				//XHR객체를 사용하지 못 하는 경우
				console.olog("AJAX객체 생성 실패")
			}
			
		}
	
	}

	//XHR객체 반환
	return xmlReq;
}
</script>

<script type="text/javascript">

//AJAX 객체 변수
var xmlHttp = null;

function calc() {
	console.log("calc called")
	
	//XHR객체 생성
	xmlHttp = createXHR();
	console.log(xmlHttp)
	
	//--- 전달 데이터 구하기 ---
	var n1 = num1.value;
	var n2 = num2.value;
	var op = oper.value;
	console.log(n1, n2, op)
	
	//--- AJAX 요청 전 설정 ---
	//요청 URL
	var url = "/ajax/ajax_02_ok.jsp"
	
	//요청 Method
	var method = "POST"
	
	//요청 파라미터
	var params = "num1="+n1+"&num2="+n2+"&oper="+op
	
	//서버의 응답을 전달받을 때 호출 될 콜백함수
	xmlHttp.onreadystatechange = callback;
		
	//--- AJAX요청 준비 ---
// 	xmlHttp.open(method, url + "?" + params) //GET
	xmlHttp.open(method, url) //POST
	
	//요청 데이터 형식(인코딩) 설정
	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
	
	//--- AJAX요청 보내기 ---
// 	xmlHttp.send(null) //GET
	xmlHttp.send(params) //POST


}

//응답데이터를 처리할 콜백함수
function callback() {
	console.log("callback called")
	
	//readyState == 4, DONE, 응답 완료 상태
	if(xmlHttp.readyState == 4) {
		console.log("응답받기 완료")
		
		
		if(xmlHttp.status == 200) { //200 OK
			console.log("정상 응답")
			
			console.log("--- 응답 데이터 ---")
			console.log(xmlHttp.responseText)
			
			resultLayout.innerHTML = xmlHttp.responseText;
		
			//입력창 초기화
			num1.value = "";
			num2.value = "";
			oper.value = "add";
			
		} else {
			console.log("error", xmlHttp.status, xmlHttp.statusText)
		}
		
	}
}

</script>

</head>
<body>

<h1>계산기 02</h1>
<h3>AJAX HTTP 통신(비동기식)</h3>
<hr>

<input type="text" id="num1" />
<select id="oper">
	<option value="add">더하기</option>
	<option value="sub">빼기</option>
	<option value="mul">곱하기</option>
	<option value="div">나누기</option>
</select>
<input type="text" id="num2" />

<button onclick="calc();"> = </button>

<hr>
<!-- AJAX요청의 응답을 적용할 DIV -->
<div id="resultLayout"></div>


</body>
</html>