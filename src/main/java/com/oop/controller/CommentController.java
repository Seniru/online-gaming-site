package com.oop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.oop.models.RegisteredUser;
import com.oop.models.Game;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CommentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		RegisteredUser user = (RegisteredUser) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
		String body = request.getParameter("comment");
        Game game = Game.fromTitle(title);

		user.postComment(game, body);
		response.sendRedirect("play?title=" + title);

    }
}
