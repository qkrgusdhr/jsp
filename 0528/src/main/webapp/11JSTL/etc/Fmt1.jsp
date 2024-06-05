<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - fmt 1</title>
</head>
<body>
	<h4>숫자 포맷 설정</h4>
	<c:set var="num1" value="12345"/>
	콤마 O : <fmt:formatNumber value="${ num1 }"/><br />
	콤마 x : <fmt:formatNumber value="${ num1 }" groupingUsed="false"/><br />
	<fmt:formatNumber value="${ num1 }" type="currency" var="printNum1"/>
	통화기호 : ${ printNum1 } <br />
	<fmt:formatNumber value="0.03" type="percent" var="printNum2"/>
	퍼센트 : ${ printNum2 } <br />
	
	<h4>문자열을 숫자로 변경</h4>
	<c:set var="strNum" value="6,789.01"/>
	<fmt:parseNumber value="${ strNum }" pattern="00,000.00" var="printNum3"/>
	소수점까지 : ${ printNum3 }
	<fmt:parseNumber value="${ strNum }" integerOnly="true" var="printNum4"/>
	정수 부분만 : ${ printNum4 }
</body>
</html>