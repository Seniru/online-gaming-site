package com.oop.utils;

import java.sql.*;

public class DBConn {
  public static Connection getConnection() throws SQLException {
    // Load the JDBC driver
    try {
      Class.forName("com.mysql.jdbc.Driver");
      // Establish a connection to the database
      Connection conn =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/online_gaming", "root", "");
      return conn;
    } catch (ClassNotFoundException e) {
    }
    return null;
  }
}
