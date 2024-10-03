package com.oop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/explore")
public class Explore extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Explore() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/explore.jsp");
		dispatcher.forward(request, response);

    }

}
