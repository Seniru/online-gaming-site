package com.oop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.oop.models.RegisteredUser;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        RegisteredUser user = RegisteredUser.fromUsername(username);

        if (user == null) {
            request.setAttribute("error", "Account not found");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
            dispatcher.forward(request, response);
        } else {
            if (password.equals(user.getPassword())) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("explore");
            } else {
                request.setAttribute("error", "Invalid password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
