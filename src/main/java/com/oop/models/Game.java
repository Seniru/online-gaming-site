package com.oop.models;

import java.util.ArrayList;
import java.io.Writer;
import java.io.IOException;
import java.sql.*;

import com.oop.utils.DBConn;

public class Game extends GameBase {

    private RegisteredUser developer;

    public Game(
            String title,
            String description,
            String image,
            String url,
            ArrayList<Category> categories,
            RegisteredUser developer) {
        super(title, description, image, url, categories);
        this.developer = developer;
    }

    public static Game fromTitle(String title) {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Game WHERE Gtitle = ?");
            PreparedStatement catStmt = conn.prepareStatement("SELECT * FROM GameCategory WHERE Title = ?");
            catStmt.setString(1, title);
            stmt.setString(1, title);
            ResultSet cats = catStmt.executeQuery();
            ResultSet res = stmt.executeQuery();

            ArrayList<Category> categories = new ArrayList<Category>();
            while (cats.next()) {
                categories.add(Category.fromCname(cats.getString("Cname")));
            }

            if (res.next()) {
                return new Game(
                        res.getString("Gtitle"),
                        res.getString("Description"),
                        res.getString("Image"),
                        res.getString("Url"),
                        categories,
                        null);
            }
            return null;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Game> getAllGames() {
        ArrayList<Game> games = new ArrayList<Game>();

        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Game WHERE NOT IsPro");

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Game game =
                        new Game(
                                res.getString("Gtitle"),
                                res.getString("Description"),
                                res.getString("Image"),
                                res.getString("Url"),
                                new ArrayList<Category>(),
                                null);

                games.add(game);
            }
            return games;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Game> getTrendingGames() {
        ArrayList<Game> games = new ArrayList<Game>();

        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Game WHERE NOT IsPro");

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Game tGame =
                        new Game(
                                res.getString("Gtitle"),
                                res.getString("Description"),
                                res.getString("Image"),
                                res.getString("Url"),
                                new ArrayList<Category>(),
                                null);

                games.add(tGame);
            }
            return games;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Game> getRecommendedGames() {
        ArrayList<Game> games = new ArrayList<Game>();

        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Game WHERE NOT IsPro");

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Game rgame =
                        new Game(
                                res.getString("Gtitle"),
                                res.getString("Description"),
                                res.getString("Image"),
                                res.getString("Url"),
                                new ArrayList<Category>(),
                                null);

                games.add(rgame);
            }
            return games;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Game> searchGames(String query, ArrayList<Category> categories) {
        ArrayList<Game> games = new ArrayList<Game>();

        try {
            Connection conn = DBConn.getConnection();
            Statement stmt = conn.createStatement();
            String subq = "SELECT DISTINCT Title FROM GameCategory";
            String sql = null;

            if (categories.size() > 0) {
                subq += " WHERE (";
                int categorySize = categories.size();
                for (int i = 0; i < categorySize; i++) {
                    subq += "Cname = '" + categories.get(i).getCname() + "'";
                    if ((i + 1) < categorySize) subq += " OR ";
                }
                subq += ")";
                sql =
                        "SELECT * FROM ("
                                + subq
                                + " ) AS f INNER JOIN Game g ON f.Title = g.Gtitle WHERE Gtitle"
                                + " LIKE '%"
                                + (query == null ? "" : query)
                                + "%'";
            } else {
                sql =
                        "SELECT * FROM Game WHERE NOT IsPro AND Gtitle LIKE '%"
                                + (query == null ? "" : query)
                                + "%'";
            }
            System.out.println(sql);
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Game rgame =
                        new Game(
                                res.getString("Gtitle"),
                                res.getString("Description"),
                                res.getString("Image"),
                                res.getString("Url"),
                                new ArrayList<Category>(),
                                null);

                games.add(rgame);
            }
            return games;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Game> getGamesFrom(RegisteredUser user) {
        ArrayList<Game> games = new ArrayList<Game>();

        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM Game WHERE DeveloperName = ?");
            stmt.setString(1, user.getUsername());
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Game rgame =
                        new Game(
                                res.getString("Gtitle"),
                                res.getString("Description"),
                                res.getString("Image"),
                                res.getString("Url"),
                                new ArrayList<Category>(),
                                null);

                games.add(rgame);
            }
            return games;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void load() {}

    @Override
    public void save() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement(
                            "REPLACE INTO Game (Gtitle, Image, URL, Description, DeveloperName)"
                                    + " VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, this.title);
            stmt.setString(2, this.image);
            stmt.setString(3, this.url);
            stmt.setString(4, this.description);
            stmt.setString(5, this.developer.getUsername());
            stmt.executeUpdate();

            for (Category cat : this.categories) {
                PreparedStatement catStmt =
                        conn.prepareStatement("INSERT INTO GameCategory VALUES (?, ?)");
                catStmt.setString(1, cat.getCname());
                catStmt.setString(2, this.title);
                catStmt.executeUpdate();
            }

        } catch (SQLException a) {
            System.out.println(a);
        }
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

    @Override
    public void delete() {
        try {
            Connection conn = DBConn.getConnection();
            Statement stmt = conn.createStatement();
            String queries[] = {
                "DELETE FROM Play WHERE Gtitle = ",
                "DELETE FROM Favourites WHERE Gtitle = ",
                "DELETE FROM GameCategory WHERE Title = ",
                "DELETE FROM UserComment WHERE Gtitle = ",
                "DELETE FROM Comment WHERE Gtitle = ",
                "DELETE FROM Game WHERE Gtitle = "
            };
            for (String query : queries) {
                stmt.executeUpdate(query + "'" + title + "'");
                System.out.println(query + "'" + title + "'");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
