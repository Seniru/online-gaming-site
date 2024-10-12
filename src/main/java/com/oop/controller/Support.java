package com.oop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.oop.models.Ticket;
import com.oop.models.RegisteredUser;

@WebServlet("/support")
public class Support extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Support() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/support.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RegisteredUser user = (RegisteredUser) request.getSession().getAttribute("user");
        Ticket ticket =
                user.createTicket(request.getParameter("title"), request.getParameter("content"));
        response.sendRedirect("tickets?id=" + ticket.getTicketID());
    }
}
