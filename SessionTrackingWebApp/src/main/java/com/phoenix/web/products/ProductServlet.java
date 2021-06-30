package com.phoenix.web.products;

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
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession obj = request.getSession(false);
		PrintWriter a = response.getWriter();
		//current session
		if(obj!= null) {
			String user = (String)obj.getAttribute("user");
			a.println("Hi! "+ user +" Enjoy Shopping");
			System.out.println("Session ID in ProductServlet: "+ obj.getId());
		}
		//no session
		else {
			a.println("<p>Sorry! No Session</p>");
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
