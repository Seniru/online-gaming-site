package com.oop.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.IOException;

import com.oop.utils.DBConn;

public class CustomerSupportAgent extends BaseUser {

    public CustomerSupportAgent(
            String username, String password, String email, String profilePicture) {
        super(username, password, email, profilePicture);
    }

    public static CustomerSupportAgent fromUsername(String username) {
        if (username == null) return null;
        try {
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement(
                            "SELECT * FROM User u INNER JOIN SupportAgent a ON u.Username ="
                                + " a.Username WHERE u.Username = ?");
            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                return new CustomerSupportAgent(
                        res.getString("Username"),
                        res.getString("Password"),
                        res.getString("Email"),
                        "");
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void onLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.getSession().setAttribute("user", this);
        request.getSession().setAttribute("role", "agent");
        response.sendRedirect("tickets");
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Cannot delete customer support agents!");
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
}
