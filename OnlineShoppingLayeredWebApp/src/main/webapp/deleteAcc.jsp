<%@page import="com.phoenix.services.LoginServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session = "false" import="com.phoenix.services.LoginService, com.phoenix.services.LoginService, com.phoenix.data.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<% 
		HttpSession ss = request.getSession(false);
		String userName = (String)ss.getAttribute("user");
		LoginService ls = new LoginServiceImpl();
		User user = ls.findUserById(userName);
		ls.remove(user);
		ss.invalidate();
		response.sendRedirect("login.html"); 
	%>
</body>
</html>