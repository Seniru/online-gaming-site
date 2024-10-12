package com.oop.models;

import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

import com.oop.utils.DBConn;

public class ProGame extends GameBase {

    public ProGame(
            String title,
            String description,
            String image,
            String url,
            ArrayList<Category> categories) {
        super(title, description, image, url, categories);
    }

    public static ArrayList<ProGame> getAllGames() {
        ArrayList<ProGame> games = new ArrayList<ProGame>();

        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Game WHERE IsPro");

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                ProGame game =
                        new ProGame(
                                res.getString("Gtitle"),
                                res.getString("Description"),
                                res.getString("Image"),
                                res.getString("Url"),
                                new ArrayList<Category>());

                games.add(game);
            }
            return games;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void load() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void print(Writer out) {
        try {
            out.write(
                    "<div class=\"game container\">"
                            + "<img src=\""
                            + this.getImage()
                            + "\">"
                            + "<span><a href=\"./play?title="
                            + this.getTitle()
                            + "\">"
                            + this.getTitle()
                            + "</a></span>"
                            + "</div>");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
