<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String inactiveToday = request.getParameter("inactiveToday");
if ("1".equals(inactiveToday)) {
    Cookie popupCookie = new Cookie("PopupClose", "off");
    popupCookie.setMaxAge(24 * 60 * 60); // 1 day
    response.addCookie(popupCookie);
    out.print("success");
} else {
    out.print("failure");
}
%>