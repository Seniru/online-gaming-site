package com.oop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.models.RegisteredUser;
import com.oop.models.Game;
import com.oop.models.Comment;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CommentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("delete".equals(request.getParameter("action"))) {
            String title = request.getParameter("title");
            int id = Integer.parseInt(request.getParameter("id"));
            Comment comment = new Comment(id, Game.fromTitle(title), null, null, null);
            comment.delete();
            response.sendRedirect("play?title=" + title);
        }
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
