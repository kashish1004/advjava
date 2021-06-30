<jsp:useBean id="ob" class="com.phoenix.web.models.LoginBean" scope="request"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
</html>
<%@ include file="header.html" %>
<h2>Hello <%= ob.getUsername() %>, Shop the best products available</h2>
<% 	
	session = request.getSession();
	session.setAttribute("user",ob.getUsername());
	session.setMaxInactiveInterval(10);
%>
<h2>Session Expires in: <%=session.getMaxInactiveInterval()%> Seconds</h2>
<% 
	String url = response.encodeURL("products.jsp");
%>
<p>To go to Shopping page <a href =<%=url %>>Click Here</a></p>
<%@ include file="footer.html" %>