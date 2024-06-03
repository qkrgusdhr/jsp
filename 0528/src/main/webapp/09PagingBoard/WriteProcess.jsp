<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./IsLoggendIn.jsp" %>
<%
String title = request.getParameter("title");
String content = request.getParameter("content");

BoardDTO dto = new BoardDTO();
dto.setId(session.getAttribute("UserId").toString());
dto.setTitle(title);
dto.setContent(content);

BoardDAO dao = new BoardDAO();
//int iResult = dao.insertWrite(dto);
int iResult = 0;
for(int i =1; i <= 100; i++){
	dto.setTitle(title + "-" + i);
	iResult = dao.insertWrite(dto);
}
dao.close();

if(iResult == 1){
	response.sendRedirect("List.jsp");
} else {
	JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
}
%>