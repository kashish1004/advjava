<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
</html>
<%@ include file="header.html" %>
<%
	HttpSession obj = request.getSession(false);
	//current session
	if(obj!= null) {
		String user = (String)obj.getAttribute("user");
		out.println("Hi! "+ user +" Enjoy Shopping");
	}
	//no session
	else {
		out.println("<p>Sorry! No Session</p>");
	} %>
<%@ include file="footer.html" %>