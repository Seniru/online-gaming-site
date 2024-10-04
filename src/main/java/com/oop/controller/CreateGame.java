package com.oop.controller;

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.oop.models.Game;
import com.oop.models.Category;

@WebServlet("/upload")
public class CreateGame extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateGame() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

                
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/upload-games.jsp");
		dispatcher.forward(request, response);
		
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        Game newGame = new Game(
            request.getParameter("title"),
            request.getParameter("description"),
            request.getParameter("image"),
            request.getParameter("url"),
            new ArrayList<Category>()
        );
		newGame.save();

	}

}
