package com.oop.models;

import java.sql.*;

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
          conn.prepareStatement("REPLACE INTO User (Username, Email, Password) VALUES (?, ?, ?)");
      stmt.setString(1, this.username);
      stmt.setString(2, this.email);
      stmt.setString(3, this.password);
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
}
