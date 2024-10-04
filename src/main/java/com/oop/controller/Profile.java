package com.oop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/profile")
public class Profile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Profile() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/profile.jsp");
		dispatcher.forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

                

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

	}
}
