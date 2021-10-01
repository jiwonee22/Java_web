<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnCalc").click(function() {
		console.log("btnCalc clicked")
		
		//요청 URL
		var url = "/jqAjax/jqAjax_ok.jsp"
		
		//요청 파라미터 - String 타입 (쿼리스트링)
		var data = "n1=" + $("#num1").val() 
			+ "&n2=" + $("#num2").val()
			+ "&op=" + $("#oper").val();
		console.log("data", data)
		
		//요청 파라미터 - plainObject 타입(JS Object)
		var dataObj = {
			"n1": $("#num1").val()
			, "n2": $("#num2").val()
			, "op": $("#oper").val()
		};
		console.log("dataOJbj", dataObj)
		
		
// 		//GET방식으로 AJAX요청 보내기
// 		$.get(url, dataObj, function (res) {
// 			console.log("--- 응답 데이터 ---")
// 			console.log(res)
			
// 			//응답 데이터 반영하기
// 			$("#resultLayout").html(res);
			
// 			//입력창 초기화
// 			$("#num1").val("");
// 			$("#num2").val("");
// 			$("#oper").val("add");

// 			//#num1으로 포커스 주기
// 			$("#num1").focus();
			
//----------------------------------------
			
		//POST방식으로 AJAX요청 보내기
		$.post(url, dataObj, function (res) {
			console.log("--- 응답 데이터 ---")
			console.log(res)
			
			//응답 데이터 반영하기
			$("#resultLayout").html(res);
			
			//입력창 초기화
			$("#num1").val("");
			$("#num2").val("");
			$("#oper").val("add");

			//#num1으로 포커스 주기
			$("#num1").focus();
			
			
			
			
		})
		
		
	})	
})

</script>



</head>
<body>

<h1>jQuery AJAX 계산기 01</h1>
<hr>

<input type="text" id="num1" />
<select id="oper">
	<option value="add">더하기</option>
	<option value="sub">빼기</option>
	<option value="mul">곱하기</option>
	<option value="div">나누기</option>
</select>
<input type="text" id="num2" />

<button id="btnCalc"> = </button>

<hr>
<div id="resultLayout"></div>

</body>
</html>