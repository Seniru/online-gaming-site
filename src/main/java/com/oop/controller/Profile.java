package com.oop.controller;

import java.io.IOException;
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

        if (request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "Delete account":
                    delete(request, response);
                    break;
                case "Become a pro!":
                    break;
                case "Become a developer":
                    break;
            }
        } else if (request.getParameter("update") != null) {
            updateProfile(request, response);
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

    protected void updateProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        RegisteredUser user = (RegisteredUser) session.getAttribute("user");
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.save();
    protected void becomeDeveloper(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             RegisteredUser user = (RegisteredUser) session.getAttribute("user");   




        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(request, response);
    }
}
