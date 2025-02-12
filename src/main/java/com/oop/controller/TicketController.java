package com.oop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.oop.models.Ticket;

@WebServlet("/tickets")
public class TicketController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TicketController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = -1;

        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }

        if (id == -1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/view-tickets.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/pages/view-ticket.jsp?" + request.getParameter("id"));
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Ticket t = Ticket.fromTicketID(id);

        if (request.getParameter("resolve") != null) {
            t.resolve();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/view-ticket.jsp");
            dispatcher.forward(request, response);
        } else if (request.getParameter("delete") != null) {
            t.delete();
            response.sendRedirect("tickets");
        }
    }
}
