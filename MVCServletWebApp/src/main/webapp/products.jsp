<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
</html>
<%
	HttpSession obj = request.getSession(false);
	//current session
	if(obj!= null) { %>
			<%@ include file="header.html" %>
		<%
			String user = (String)obj.getAttribute("user");
			out.println("Hi! "+ user +" Enjoy Shopping");
		%>
			<%@ include file="footer.html" %>
	<% }
	//no session
	else {
		out.println("<p>Sorry! No Session</p>");
	} %>
