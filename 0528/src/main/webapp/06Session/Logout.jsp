<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
session.removeAttribute("UserId");
session.removeAttribute("UserName");

response.sendRedirect("LoginForm.jsp");
%>
