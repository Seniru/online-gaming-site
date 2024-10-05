package com.oop.models;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.*;

import com.oop.utils.DBConn;
import com.oop.exceptions.GamehubException;

public class Category implements Persistable, Printable {
	
	private String cname;
	private String icon;
	private String color;

	public Category(String cname, String icon, String color) {
		this.cname = cname;
		this.icon = icon;
		this.color = color;
	}

	public String getCname() {
		return this.cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static ArrayList<Category> getAllCategories() {
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			Connection conn = DBConn.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM Category");
			
			while (res.next()) {
				categories.add(new Category(
					res.getString("Cname"),
					res.getString("Icon"),
					res.getString("Color")
				));
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return categories;
	}

	public static Category fromCname(String cname) {
		try {
			Category cat = new Category(cname, null, null);
			cat.load();
			return cat;
		} catch (GamehubException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void print(PrintWriter out) {
        String html =
                "<div class=\"chip\">"
                + "<i class=\"" + this.icon + "\" style=\"color:" + this.color + ";\"></i>"
                + "<div class=\"name-container\">" + this.cname + "</div>"
                + "</div>";

        out.print(html);
	}

	@Override
	public void load() throws GamehubException {
		try{
			Connection conn = DBConn.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Category WHERE cname = ? ");
			stmt.setString(1,cname);
			ResultSet res = stmt.executeQuery();

			if (res.next()){

				this.cname = res.getString("Cname");
				this.icon = res.getString("Icon");
				this.color = res.getString("Color");

			} else {
				System.out.println("Category not found");
				throw new GamehubException("Category not found");
			}

		} catch (SQLException e){
			System.out.println(e);
		}
	}

	@Override
	public void save() {
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement stmt = conn.prepareStatement("REPLACE INTO Category (Cname, Icon, Color ) VALUES (?, ?, ?)");
			stmt.setString(1, this.cname);
			stmt.setString(2, this.icon);
			stmt.setString(3, this.color);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
    
}
