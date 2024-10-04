package com.oop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.oop.models.RegisteredUser;
s

@WebServlet("/signup")
public class Signup extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Signup() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        		response.setContentType("text/html");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/signup.jsp");
		dispatcher.forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

		RegisteredUser newUser = new RegisteredUser(
			request.getParameter("username"),
			request.getParameter("password"),
			request.getParameter("email"),
			"",
			false,
			false
		);

		request.getSession().setAttribute("user", newUser);

		//newUser.save();
		response.sendRedirect("explore");

	}
}
