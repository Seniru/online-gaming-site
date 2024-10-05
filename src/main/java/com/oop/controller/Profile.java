package com.oop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import com.oop.models.RegisteredUser;

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

		switch (request.getParameter("action")) {
            case "Delete account":
                delete(request, response);
                break;
            case "Become a pro!":
                break;
            case "Become a developer":
                break;
        }

	}

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        RegisteredUser user = (RegisteredUser) session.getAttribute("user");
        user.delete();
		response.sendRedirect("explore");
        session.removeAttribute("user");

    }
}
