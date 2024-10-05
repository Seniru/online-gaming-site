package com.oop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        List<String> categoryValues = Arrays.asList(request.getParameterValues("category[]"));
        ArrayList<Category> categories = new ArrayList<Category>();

        for (String cat : categoryValues) {
            Category category = Category.fromCname(cat);
            if (category != null) categories.add(category);
        }

        Game newGame = new Game(
            request.getParameter("title"),
            request.getParameter("description"),
            request.getParameter("image"),
            request.getParameter("url"),
            categories
        );
		
        newGame.save();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/explore.jsp");
		dispatcher.forward(request, response);

	}

}
