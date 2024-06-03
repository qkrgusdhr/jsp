<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.DBConnPool"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 추가 테스트(executeUpdate() 사용)</h2>
	<%
	DBConnPool pool = new DBConnPool();
	
	String id = "test2";
	String pwd = "1111";
	String name = "테스트2";
	
	String sql = "INSERT INTO LOGIN VALUES (?,?,?,SYSDATE)";
	PreparedStatement pstmt = pool.con.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, pwd);
	pstmt.setString(3, name);
	
	int inResult = pstmt.executeUpdate();
	out.println(inResult + "행이 실행되었습니다.");
	
	pool.close();
	%>
</body>
</html>