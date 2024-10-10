package com.oop.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import com.oop.utils.DBConn;

public class RegisteredUser extends BaseUser {

    private boolean isPro;
    private boolean isDev;

    public RegisteredUser(
            String username,
            String password,
            String email,
            String profilePicture,
            boolean isPro,
            boolean isDev) {
        super(username, password, email, profilePicture);
        this.isPro = isPro;
        this.isDev = isDev;
    }

    public void play(GameBase game) {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Play (Gtitle, Username) VALUES (?, ?)");
            stmt.setString(1, game.getTitle());
            stmt.setString(2, this.getUsername());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void saveGame(GameBase game) {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Favourites (Gtitle, Username) VALUES (?, ?)");
            stmt.setString(1, game.getTitle());
            stmt.setString(2, this.getUsername());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public ArrayList<Game> getPlayedGames() {
        try {
            ArrayList<Game> playedGames = new ArrayList<Game>();
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT Gtitle FROM Play WHERE Username = ?");
            stmt.setString(1, this.username);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                playedGames.add(Game.fromTitle(
                    res.getString("Gtitle")
                ));
            }
            Collections.reverse(playedGames);
            return playedGames;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<Game> getSavedGames() {
        try {
            ArrayList<Game> favouriteGames = new ArrayList<Game>();
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT Gtitle FROM Favourites WHERE Username = ?");
            stmt.setString(1, this.username);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                favouriteGames.add(Game.fromTitle(
                    res.getString("Gtitle")
                ));
            }
            Collections.reverse(favouriteGames);
            return favouriteGames;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static RegisteredUser fromUsername(String username) {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE Username = ?");
            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                return new RegisteredUser(
                        res.getString("Username"),
                        res.getString("Password"),
                        res.getString("Email"),
                        "",
                        false,
                        false);
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void delete() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement userDeleteStmt =
                    conn.prepareStatement("DELETE FROM User WHERE Username = ?");
            userDeleteStmt.setString(1, username);
            userDeleteStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void load() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();
            this.username = res.getString("Username");
            this.password = res.getString("Password");
            this.email = res.getString("Email");
            this.profilePicture = res.getString("ProfilePicture");
            this.isPro = false;
            this.isDev = false;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void save() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement(
                            "REPLACE INTO User (Username, Email, Password) VALUES (?, ?, ?)");
            stmt.setString(1, this.username);
            stmt.setString(2, this.email);
            stmt.setString(3, this.password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
