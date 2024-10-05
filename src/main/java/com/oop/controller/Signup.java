package com.oop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.sql.*;

import com.oop.models.RegisteredUser;

@WebServlet("/signup")
public class Signup extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Signup() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/signup.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RegisteredUser newUser =
        new RegisteredUser(
            request.getParameter("username"),
            request.getParameter("password"),
            request.getParameter("email"),
            "",
            false,
            false);

    newUser.save();
    request.getSession().setAttribute("user", newUser);
    response.sendRedirect("explore");
  }
}
