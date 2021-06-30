<jsp:useBean id="ob" class="com.phoenix.web.models.LoginBean" scope="request"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
</html>
<%@ include file="header.html" %>
<h2>Hello <jsp:getProperty property="username" name="ob"/>, Shop the best products available</h2>
<% 	String uname = request.getParameter("username");
	session.setAttribute("user",uname);
	session.setMaxInactiveInterval(4);
	String url = response.encodeURL("products.jsp");
%>
<h2>Session Expires in: <%=session.getMaxInactiveInterval()%> Seconds</h2>
<p>To go to Shopping page <a href =<%=url %>>Click Here</a></p>
<%@ include file="footer.html" %>