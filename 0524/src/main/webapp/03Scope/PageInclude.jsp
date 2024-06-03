<%@page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>Include 페이지</h4>
<%
Person person2 = (Person)(pageContext.getAttribute("pagePerson"));
%>
<ul>
	<li>Integer 객체 : <%=pageContext.getAttribute("pageInteger")  %> </li>
	<li>String 객체 : <%=pageContext.getAttribute("pageString") %> </li>
	<li>Person 객체 : <%= person2.getName() %>, <%= person2.getAge() %> </li>
</ul>
