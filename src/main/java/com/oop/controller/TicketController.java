package com.oop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.models.Ticket;
import com.oop.models.RegisteredUser;

@WebServlet("/Ticket")
public class TicketController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TicketController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Ticket newTicket =
                new Ticket(
                        0,
                        request.getParameter("Title"),
                        request.getParameter("Body"),
                        (RegisteredUser) request.getSession().getAttribute("user"));

        newTicket.save();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    }
}
