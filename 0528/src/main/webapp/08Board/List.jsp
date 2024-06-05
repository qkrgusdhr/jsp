
<%@page import="board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
}

section.notice {
	padding: 80px 0;
}

.page-title {
	margin-bottom: 60px;
}

.page-title h3 {
	font-size: 28px;
	color: #333333;
	font-weight: 400;
	text-align: center;
}

#board-search .search-window {
	padding: 15px 0;
	background-color: #f9f7f9;
}

#board-search .search-window .search-wrap {
	position: relative;
	/*   padding-right: 124px; */
	margin: 0 auto;
	width: 80%;
	max-width: 564px;
}

#board-search .search-window .search-wrap input {
	height: 40px;
	width: 100%;
	font-size: 14px;
	padding: 7px 14px;
	border: 1px solid #ccc;
}

#board-search .search-window .search-wrap input:focus {
	border-color: #333;
	outline: 0;
	border-width: 1px;
}

#board-search .search-window .search-wrap .btn {
	position: absolute;
	right: 0;
	top: 0;
	bottom: 0;
	width: 108px;
	padding: 0;
	font-size: 16px;
}

.board-table {
	font-size: 13px;
	width: 100%;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	margin-bottom: 20px; /* 아래쪽 마진 설정 */
	text-align: center;
}

.board-table a {
	display: inline-block;
    max-width: 420px;
    font-size: 14px;
    font-weight: bold;
    color: #333;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
    text-decoration-line: none;
}

.board-table th {
	text-align: center;
}

.board-table .th-num {
	width: 100px;
	text-align: center;
}

.board-table .th-title {
	width: 400px;
}

.board-table .th-name {
	width: 80px;
}

.board-table .th-date {
	width: 100px;
}

.board-table .th-visitcount {
	width: 100px;
}

.board-table th, .board-table td {
	padding: 14px 0;
}

.btn {
	display: inline-block;
	padding: 0 30px;
	font-size: 15px;
	font-weight: 400;
	background: transparent;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	border: 1px solid transparent;
	text-transform: uppercase;
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	border-radius: 0;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	-ms-transition: all 0.3s;
	-o-transition: all 0.3s;
	transition: all 0.3s;
}

.btn-dark {
	background: #555;
	color: #fff;
	width: 108px;
	height: 40px;
}

.btn-dark:hover, .btn-dark:focus {
	background: #373737;
	border-color: #373737;
	color: #fff;
}

/* reset */
* {
	list-style: none;
	text-decoration: none;
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

.clearfix:after {
	content: '';
	display: block;
	clear: both;
}

.container {
	width: 1100px;
	margin: 0 auto;
}

.blind {
	position: absolute;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	margin: -1px;
	width: 1px;
	height: 1px;
}
</style>


<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<%
BoardDAO dao = new BoardDAO();

Map<String, Object> param = new HashMap<String, Object>();
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if (searchWord != null) {
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(param);
List<BoardDTO> list = dao.selectList(param);
dao.close();
%>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
</head>
<body>
	<jsp:include page="../06Session/Link.jsp"></jsp:include>
	<h2>목록 보기(List)</h2>



	<section class="notice">
		<div class="page-title">
			<div class="container">
				<h3>게시판</h3>
			</div>
		</div>

		<!-- board seach area -->
		<div id="board-search">
			<div class="container">
				<div class="search-window">
					<div class="col-md-12">
						<form method="get" action="">
							<div class="row justify-content-center">
								<div class="col-md-1">
									<select name="searchField" style="width: 60; height: 40;">
										<option value="title">제목</option>
										<option value="content">내용</option>
									</select>
								</div>
								<div class="col-md-5">
									<input id="testinput" type="search" name="searchWord"
										placeholder="검색어를 입력해주세요." style="width: 500px; height: 40px;"
										value="">
								</div>
								<div class="col-md-2">
									<button type="submit" class="btn btn-dark">검색</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>



		<!-- board list area -->
		<div id="board-list">
			<div class="container">
				<table class="board-table">
					<thead>
						<tr>
							<th scope="col" class="th-num">번호</th>
							<th scope="col" class="th-title">제목</th>
							<th scope="col" class="th-name">작성자</th>
							<th scope="col" class="th-visitcount">조회수</th>
							<th scope="col" class="th-date">작성일</th>
						</tr>
						<%
						if (list.isEmpty()) {
						%>
						<tr>
							<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
						</tr>
						<%
						} else {
						int virtualNum = totalCount;
						for (BoardDTO dto : list) {
							virtualNum--;
						%>
					</thead>

					<tr align="center">
						<td><%=virtualNum%></td>
						<td align="center"><a href="View.jsp?num=<%=dto.getNum()%>"><%=dto.getTitle()%></a>
						</td>
						<td align="center"><%=dto.getId()%></td>
						<td align="center"><%=dto.getVisitcount()%></td>
						<td align="center"><%=dto.getPostdate()%></td>
					</tr>
					<%
					}
					}
					%>

				</table>
				<div class="col text-end">
					<button type="button" class="btn btn-primary"
						onclick="location.href='Write.jsp';">글쓰기</button>
				</div>
			</div>
		</div>

	</section>

</body>
</html>
