<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<title>세션</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous"/>
<script>
	function validateForm(form) {
		if (form.user_id.value == "") {
			alert("아이디를 입력하세요.");
			return false;
		}
		if (form.user_pw.value == "") {
			alert("패스워드를 입력하세요.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<jsp:include page="../06Session/Link.jsp"></jsp:include>
	<div class="container">
		<h2>로그인 페이지</h2>
		<span style="color: red; font-size: 1.2em"> <%=request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg")%>
		</span>
		<%
		if (session.getAttribute("UserId") == null) {
		%>
		<form action="LoginProcess.jsp" method="post" name="loginFrm"
			onsubmit="return validateForm(this);">
			<div class="form-floating mb-3" style="width:300px">
				<input type="text" class="form-control" name="user_id"
					placeholder="id"> <label for="floatingInput">ID </label>
			</div>
			<div class="form-floating" style="width: 300px">
				<input type="password" class="form-control" name="user_pw"
					placeholder="Password"> <label for="floatingPassword">Password</label>
			</div>
			<br />
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
		<%
		} else {
		%>
		<p><%=session.getAttribute("UserName")%>
			회원님, 로그인 하셨습니다.
		</p>
		<a href="Logout.jsp" class="btn btn-danger">로그아웃</a>
		<%
		}
		%>
	</div>
</body>
</html>
