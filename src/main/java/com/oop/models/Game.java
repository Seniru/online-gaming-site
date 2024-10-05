package com.oop.models;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.sql.*;

import com.oop.utils.DBConn;

public class Game extends GameBase {

	public Game(String title, String description, String image, String url, ArrayList<Category> categories) {
		super(title, description, image, url, categories);
	}

	@Override
	public void load() {

	}

	@Override
	public void save() {
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement stmt = conn.prepareStatement("REPLACE INTO Game (Gtitle, Image, URL, Description) VALUES (?, ?, ?, ?)");
			stmt.setString(1,this.title);
			stmt.setString(2,this.image);
			stmt.setString(3,this.url);
			stmt.setString(4,this.description);
			stmt.executeUpdate();

			for (Category cat : this.categories) {
				PreparedStatement catStmt = conn.prepareStatement("INSERT INTO GameCategory VALUES (?, ?)");
				catStmt.setString(1, cat.getCname());
				catStmt.setString(2, this.title);
				catStmt.executeUpdate();
			}

		} catch(SQLException a){
			System.out.println(a);
		}
	}

	@Override
	public void print(PrintWriter out) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'print'");
	}
	
}
