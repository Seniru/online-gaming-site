package com.oop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.models.Game;

@WebServlet("/delete-game")
public class DeleteGame extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteGame() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        Game game = Game.fromTitle(title);
        game.delete();
        response.sendRedirect("profile");
    }
}
