package com.oop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.util.*;

import com.oop.models.RegisteredUser;
import com.oop.models.Game;

@WebServlet("/profile")
public class Profile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Profile() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("save-game".equals(request.getParameter("action"))) {
            saveGame(request, response);
        } else if ("Become a pro!".equals(request.getParameter("action"))) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/payment.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/profile.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "Delete account":
                    delete(request, response);
                    break;
                case "become-pro":
                    becomePro(request, response);
                    break;
                case "Become a developer":
                    becomeDeveloper(request, response);
                    break;
                case "Save game":
                    saveGame(request, response);
                    break;
            }
        } else if (request.getParameter("update") != null) {
            updateProfile(request, response);
        } else {
            response.getWriter().write(Collections.list(request.getAttributeNames()).toString());
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
    }

    protected void becomeDeveloper(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RegisteredUser user = (RegisteredUser) session.getAttribute("user");

        user.becomeDeveloper();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(request, response);

    }

    protected void becomePro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        RegisteredUser user = (RegisteredUser) session.getAttribute("user");
    
        user.becomePro();
    
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(request, response);
        
    }

    protected void saveGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        RegisteredUser user = (RegisteredUser) session.getAttribute("user");
        Game game = Game.fromTitle(title);
        user.saveGame(game);
    }
}
