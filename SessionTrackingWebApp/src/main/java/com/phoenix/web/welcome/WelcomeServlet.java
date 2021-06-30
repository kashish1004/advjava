package com.phoenix.web.welcome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GreetingServlet
 * @author kashish.jain@stltech.in
 * Creation Date - 23-6-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession obj = request.getSession();
		//setting session timeout
		obj.setMaxInactiveInterval(2);
		//printing session Id
		System.out.println("Session ID in WelcomeServlet : "+ obj.getId());
		String username = request.getParameter("username");
		//storing data username
		obj.setAttribute("user", username);
		//encoding url if cookie is disabled
		String url = response.encodeURL("products");
		PrintWriter p = response.getWriter();
		//response to user
		p.println("<h4>Welcome "+ username +" to online shopping</h4>");
		p.println("<p>Session Timeout Period is: "+obj.getMaxInactiveInterval()+" Seconds</p>");
		p.println("<p>To shop <a href = '"+url+"'>Click Here</a></p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
