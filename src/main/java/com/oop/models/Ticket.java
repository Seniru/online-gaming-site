package com.oop.models;

import java.sql.*;
import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;

import com.oop.utils.DBConn;

public class Ticket implements Persistable, Printable {

    private int ticketID;
    private String title;
    private String body;
    private RegisteredUser user;
    private String createdDate;
    private boolean closed;

    public Ticket(
            int ticketID,
            String title,
            String body,
            RegisteredUser user,
            String createdDate,
            boolean closed) {
        this.ticketID = ticketID;
        this.title = title;
        this.body = body;
        this.user = user;
        this.createdDate = createdDate;
        this.closed = closed;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUsername(RegisteredUser user) {
        this.user = user;
    }

    public void resolve() {
        this.closed = true;
        this.save();
    }

    public static Ticket fromTicketID(int id) {
        Ticket t = new Ticket(id, null, null, null, null, false);
        t.load();
        return t;
    }

    public static ArrayList<Ticket> getTickets(boolean resolved) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM Ticket WHERE Resolved = ?");
            stmt.setBoolean(1, resolved);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Ticket ticket =
                        new Ticket(
                                res.getInt("TicketID"),
                                res.getString("Title"),
                                res.getString("Body"),
                                RegisteredUser.fromUsername(res.getString("Username")),
                                res.getString("CreatedDate"),
                                resolved);

                tickets.add(ticket);
            }
            return tickets;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void print(Writer out) {
        try {
            out.write(
                    "<div class=\"container ticket\">"
                            + "<div>"
                            + "<img class='profile-image' src='images/user-solid.svg'>"
                            + user.getUsername()
                            + "</div>"
                            + "<h1><a href='./tickets?id="
                            + ticketID
                            + "'>"
                            + title
                            + "</a></h1>"
                            + "<div>"
                            + createdDate
                            + "</div>"
                            + "</div>");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void load() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM Ticket WHERE TicketID = ?");
            stmt.setInt(1, this.ticketID);
            ResultSet res = stmt.executeQuery();
            res.next();
            this.title = res.getString("Title");
            this.body = res.getString("Body");
            this.user = RegisteredUser.fromUsername(res.getString("Username"));
            this.createdDate = res.getString("CreatedDate");
            this.closed = res.getBoolean("Resolved");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void save() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement("REPLACE INTO Ticket VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, this.ticketID);
            stmt.setString(2, this.title);
            stmt.setString(3, this.body);
            stmt.setString(4, this.user.getUsername());
            stmt.setString(5, this.createdDate);
            stmt.setBoolean(6, this.closed);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete() {
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Ticket WHERE TicketID = ?");
            stmt.setInt(1, this.ticketID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
