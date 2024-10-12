package com.oop.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import com.oop.utils.DBConn;

public class RegisteredUser extends BaseUser {

    private boolean pro;
    private boolean dev;

    public RegisteredUser(
            String username,
            String password,
            String email,
            String profilePicture,
            boolean isPro,
            boolean isDev) {
        super(username, password, email, profilePicture);
        this.pro = isPro;
        this.dev = isDev;
    }

    public boolean isPro() {
        return pro;
    }

    public void setPro() {
        this.pro = pro;
    }

    public boolean isDev() {
        return dev;
    }

    public void setDev() {
        this.dev = dev;
    }

    public void play(GameBase game) {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement("INSERT INTO Play (Gtitle, Username) VALUES (?, ?)");
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
            PreparedStatement stmt =
                    conn.prepareStatement(
                            "INSERT INTO Favourites (Gtitle, Username) VALUES (?, ?)");
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
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT DISTINCT Gtitle FROM Play WHERE Username = ?");
            stmt.setString(1, this.username);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                playedGames.add(Game.fromTitle(res.getString("Gtitle")));
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
            PreparedStatement stmt =
                    conn.prepareStatement(
                            "SELECT DISTINCT Gtitle FROM Favourites WHERE Username = ?");
            stmt.setString(1, this.username);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                favouriteGames.add(Game.fromTitle(res.getString("Gtitle")));
            }
            Collections.reverse(favouriteGames);
            return favouriteGames;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void becomeDeveloper() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO DevUser VALUES (?)");
            stmt.setString(1, username);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void becomePro() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ProUser VALUES (?)");
            stmt.setString(1, username);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public Ticket createTicket(String title, String body) {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Ticket (Title, Body, Username, CreatedDate) VALUES (?, ?, ?, NOW())");
            stmt.setString(1, title);
            stmt.setString(2, body);
            stmt.setString(3, this.username);
            stmt.executeUpdate();

            Statement lastInsertedStmt = conn.createStatement();
            ResultSet res = lastInsertedStmt.executeQuery("SELECT LAST_INSERT_ID()");
            res.next();

            Ticket t = new Ticket(res.getInt(1), null, null, null, null, false);
            t.load();
            return t;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void postComment(Game game, String body) {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement countStmt = conn.prepareStatement("SELECT COUNT(*) FROM Comment WHERE Gtitle = ?");
            countStmt.setString(1, game.getTitle());
            ResultSet countRes = countStmt.executeQuery();
            countRes.next();
            int commentCount = countRes.getInt(1);

            PreparedStatement cmm = conn.prepareStatement("INSERT INTO Comment VALUES (?, ?, ?, NOW())");
            PreparedStatement ucmm = conn.prepareStatement("INSERT INTO UserComment VALUES (?, ?, ?)");
            cmm.setInt(1, commentCount + 1);
            cmm.setString(2, game.getTitle());
            cmm.setString(3, body);
            ucmm.setInt(1, commentCount + 1);
            ucmm.setString(2, game.getTitle());
            ucmm.setString(3, username);
            cmm.executeUpdate();
            ucmm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static RegisteredUser fromUsername(String username) {
        if (username == null) return null;
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE Username = ?");
            PreparedStatement proStmt = conn.prepareStatement("SELECT * FROM ProUser WHERE Username = ?");
            PreparedStatement devStmt = conn.prepareStatement("SELECT * FROM DevUser WHERE Username = ?");
            stmt.setString(1, username);
            proStmt.setString(1, username);
            devStmt.setString(1, username);
            ResultSet res = stmt.executeQuery();
            ResultSet proRes = proStmt.executeQuery();
            ResultSet devRes = devStmt.executeQuery();

            if (res.next()) {
                return new RegisteredUser(
                        res.getString("Username"),
                        res.getString("Password"),
                        res.getString("Email"),
                        "",
                        proRes.next(),
                        devRes.next());
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void delete() {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = DBConn.getConnection();
            conn.setAutoCommit(false);

            String queries[] = {
                "UPDATE UserComment SET `Username` = 'Deleted User' WHERE `Username` = ?",
                "UPDATE Game SET DeveloperName = 'Deleted User' WHERE `DeveloperName` = ?",
                "DELETE FROM Ticket WHERE `Username` = ?",
                "DELETE FROM ProUser WHERE `Username` = ?",
                "DELETE FROM DevUser WHERE `Username` = ?",
                "DELETE FROM Play WHERE `Username` = ?",
                "DELETE FROM Favourites WHERE `Username` = ?",
                "DELETE FROM User WHERE `Username` = ?"
            };

            for (String query : queries) {
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            System.out.println(e);
        }
    }

    @Override
    public void load() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
            PreparedStatement proStmt = conn.prepareStatement("SELECT * FROM ProUser WHERE username = ?");
            PreparedStatement devStmt = conn.prepareStatement("SELECT * FROM DevUser WHERE username = ?");
            stmt.setString(1, username);
            proStmt.setString(1, username);
            devStmt.setString(1, username);
            ResultSet res = stmt.executeQuery();
            ResultSet proRes = proStmt.executeQuery();
            ResultSet devRes = devStmt.executeQuery();
            res.next();

            this.username = res.getString("Username");
            this.password = res.getString("Password");
            this.email = res.getString("Email");
            this.profilePicture = "";
            this.pro = proRes.next();
            this.dev = devRes.next();
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
