<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
	<h2>회원 목록 조회(executeQuery() 사용)</h2>
	<%
	DBConnPool pool = new DBConnPool();

	String sql = "SELECT id, pass, name, regidate FROM LOGIN";
	Statement stmt = pool.con.createStatement();

	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){
		String id = rs.getString("id");
		String pass = rs.getString("pass");
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");
		
		out.println(String.format("%s %s %s %s", id, pass, name, regidate) + "<br/>");
	}
	
	pool.close();
	%>
</body>
</html>