package com.phoenix.web.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServlet
 * @author kashish.jain@stltech.in
 * Creation Date - 23-6-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
@WebServlet("/LoginS")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		PrintWriter obj = response.getWriter();
		//successful login
		if(username != null && passwd != null && username.equals("kashish") && passwd.equals("kas104")) {
			//dispatching to welcome servlet
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
		}
		//invalid login
		else {
			//error message to user
			obj.println("<p style = 'color:red'>Invalid username or password. Login again</p>");
			//asking user to login again
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
