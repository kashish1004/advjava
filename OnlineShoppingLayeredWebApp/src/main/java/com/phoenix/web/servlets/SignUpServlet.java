package com.phoenix.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phoenix.data.User;
import com.phoenix.services.LoginService;
import com.phoenix.services.LoginServiceImpl;
import com.phoenix.web.exceptions.UserAlreadyExistException;
import com.phoenix.web.exceptions.UserNotFoundException;
/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		String pass1 = request.getParameter("pwd1");
		LoginService ls = new LoginServiceImpl();
		if(pass.equals(pass1)) {
			try {
				User user = new User();
				User us = ls.findUserById(username);
				user.setUsername(username);
				user.setPassword(pass);
				if(us == null) {
					ls.add(user);
					response.sendRedirect("login.html");
					}
				else {
					System.out.println("User Already Exists");
				}
			} catch (UserAlreadyExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<p style = 'color:red'>Enter Same Password in both fields.</p>");
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.html");
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
