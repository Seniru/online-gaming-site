package com.oop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.models.RegisteredUser;

import java.sql.*;

@WebServlet("/Test")
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        out.println(request.getSession().getAttribute("user"));

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            conn =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/online_gaming", "root", "");

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query to retrieve data from the User table
            String sql = "SELECT Username, Email, Password FROM User";
            rs = stmt.executeQuery(sql);

            // Print the results
            out.println("<html><body>");
            out.println("<h1>User Table</h1>");
            out.println(
                    "<table border='1'><tr><th>Username</th><th>Email</th><th>Password</th></tr>");

            while (rs.next()) {
                String username = rs.getString("Username");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                out.println(
                        "<tr><td>"
                                + username
                                + "</td><td>"
                                + email
                                + "</td><td>"
                                + password
                                + "</td></tr>");
            }

            out.println("</table>");
            RegisteredUser u = RegisteredUser.fromUsername("john_doe");
            out.println(u);
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(out);
            }
        }
    }
}
