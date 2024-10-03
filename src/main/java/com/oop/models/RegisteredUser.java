package com.oop.models;

import java.sql.*;

import com.oop.utils.DBConn;

public class RegisteredUser extends BaseUser {

	private boolean isPro;
	private boolean isDev;

	public RegisteredUser(String username, String password, String email, String profilePicture, boolean isPro, boolean isDev) {
		super(username, password, email, profilePicture);
		this.isPro = isPro;
		this.isDev = isDev;
	}

	public static RegisteredUser fromUsername(String username) {
		try {
			Connection conn = DBConn.getConnection();
			ResultSet res = conn.createStatement().executeQuery("SELECT * FROM `User` WHERE `Username` = 'john_doe'");
			return new RegisteredUser(
				res.getString("Username"),
				res.getString("Password"),
				res.getString("Email"),
				res.getString("ProfilePicture"),
				false,
				false
			);
		} catch (SQLException e) {
			return new RegisteredUser(e.getMessage(), "sex", "sex", "sex", false, false);
		}
	}

	@Override
	public void load(String identifier) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'load'");
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}
	
}
