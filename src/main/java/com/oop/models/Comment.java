package com.oop.models;

import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

import com.oop.utils.DBConn;

public class Comment implements Persistable, Printable {

    private int commentID;
    private Game game;
    private String body;
    private RegisteredUser user;
    private String postedDate;

    public Comment(int commentID, Game game, String body, RegisteredUser user, String postedDate) {
        this.commentID = commentID;
        this.game = game;
        this.body = body;
        this.user = user;
        this.postedDate = postedDate;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate() {
        this.postedDate = postedDate;
    }

    public static ArrayList<Comment> getComments(GameBase game) {
        String sql =
                "SELECT * FROM UserComment uc, Comment c, User u WHERE c.CommentId = uc.commentId"
                    + " AND c.Gtitle = uc.Gtitle AND u.Username = uc.Username AND c.Gtitle = ?";

        ArrayList<Comment> comments = new ArrayList<Comment>();

        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, game.getTitle());
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                comments.add(
                        new Comment(
                                res.getInt("CommentId"),
                                Game.fromTitle(res.getString("Gtitle")),
                                res.getString("Body"),
                                RegisteredUser.fromUsername(res.getString("Username")),
                                res.getString("PostedDate")));
            }
            return comments;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void print(Writer out) {
        try {
            out.write(
                    "<div class=\"comment container\">"
                            + "<div>"
                            + "<img class='profile-image' src='images/user-solid.svg'><br>"
                            + this.user.getUsername()
                            + "</div>"
                            + "<p>"
                            + this.body
                            + "</p>"
                            + "<span>"
                            + this.postedDate
                            + "</span>"
                            + "</div>");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void load() {
        try {
            String sql =
                    "SELECT * FROM UserComment uc, Comment c, User u WHERE c.CommentId ="
                        + " uc.commentId AND c.Gtitle = uc.Gtitle AND u.Username = uc.Username AND"
                        + " c.Gtitle = ? AND c.CommentId = ?";

            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, game.getTitle());
            stmt.setInt(2, commentID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                this.body = res.getString("Body");
                this.user = RegisteredUser.fromUsername(res.getString("Username"));
                this.postedDate = res.getString("PostedDate");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt1 =
                    conn.prepareStatement(
                            "DELETE FROM UserComment WHERE Gtitle = ? AND CommentId = ?");
            PreparedStatement stmt2 =
                    conn.prepareStatement("DELETE FROM Comment WHERE Gtitle = ? AND CommentId = ?");
            stmt1.setString(1, this.game.getTitle());
            stmt1.setInt(2, this.commentID);
            stmt2.setString(1, this.game.getTitle());
            stmt2.setInt(2, this.commentID);
            stmt1.executeUpdate();
            stmt2.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }
}
