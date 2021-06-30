<!-- Controller -->
<jsp:useBean id="ob" class="com.phoenix.web.models.LoginBean" scope="request"></jsp:useBean>
<jsp:setProperty property="username" name="ob"/>
<jsp:setProperty property = "password" name = "ob" param = "passwd"/>
<%
	if(ob.isValid()){ %>
		<jsp:forward page="welcome.jsp">
			<jsp:param value="kashish" name="abc"/>
			<jsp:param value="123" name="pqr"/>
		</jsp:forward>	
<%	}
	else{ %>
		<h2>Invalid Password</h2>
		<jsp:include page="login.html"></jsp:include>
		
<%	} %>