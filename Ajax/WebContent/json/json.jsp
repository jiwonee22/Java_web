<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

//자바스크립트 객체
var jsObj = {"a":1, "b":2, "c":"Cherry", "d":true, "e":["1", 2], "f":{"key":"val"}};
console.log("--- jsObj ---")
console.log(jsObj)

var jsStr = "{\"a\":1, \"b\":2, \"c\":\"Cherry\", \"d\":true, \"e\":[\"1\", 2], \"f\":{\"key\":\"val\"}}";
var jsStr2 = '{"a":1, "b":2, "c":"Cherry", "d":true, "e":["1", 2], "f":{"key":"val"}}';

//JS객체 -> JSON텍스트 (마샬링)
var jsonText = JSON.stringify(jsObj);
console.log("--- jsonText ---")
console.log(jsonText)

// console로 확인하면 같게 보이지만 다르다!!

//JSON텍스트 -> JS객체 (언마샬링)
var jsonObj = JSON.parse(jsonText);
console.log("--- jsonObj ---")
console.log(jsonObj)


</script>

</head>
<body>

<h1>JSON TEST</h1>

</body>
</html>